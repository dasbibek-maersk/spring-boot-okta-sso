package com.maersk.spring.okta.sso;

import java.security.Principal;
import com.maersk.spring.okta.sso.constants.OktaOAuth2SsoProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import javax.inject.Named;
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SpringBootOktaSsoApplication {
  String url="http://localhost:8090/appsone/hi";
	@Inject
	@Named(OktaOAuth2SsoProperties.OKTA_OAUTH2_REST_TEMPLATE)
	private OAuth2RestTemplate oAuth2RestTemplate;

	public String callingUrlFromAnotherApp(){
		ResponseEntity<String> responseEntity = oAuth2RestTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();

	}

	class commandTest implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {

		}
	}
	
	@GetMapping("/")
	public String welcome2User(Principal principal) {
		return "Hi "+principal.getName()+" Welcome to okta ouath2";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOktaSsoApplication.class, args);
	}

}
