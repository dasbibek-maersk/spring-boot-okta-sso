package com.maersk.spring.okta.sso.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import  com.maersk.spring.okta.sso.constants.OktaOAuth2SsoProperties;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import java.util.Arrays;

@Configuration
public class OktaOAuth2RestConfiguration {
    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_USERNAME_PROPERTIES)
    private String username;

    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_PASSWORD_PROPERTIES)
    private String password;

    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_ID_PROPERTIES)
    private String id;

    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_CLIENT_ID_PROPERTIES)
    private String clientId;

    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_CLIENT_SECRET_PROPERTIES)
    private String clientSecret;

    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_ACCESS_TOKEN_URI_PROPERTIES)
    private String accessTokenUri;

    @Value(OktaOAuth2SsoProperties.RESOURCE_DETAILS_SCOPE_PROPERTIES)
    private String scope;

    @Bean(name = OktaOAuth2SsoProperties.OKTA_OAUTH2_REST_TEMPLATE)
    public OAuth2RestTemplate oauth2RestTemplate() {
        return new OAuth2RestTemplate(createResourceOwnerPasswordResourceDetails());
    }

    private OAuth2ProtectedResourceDetails createResourceOwnerPasswordResourceDetails() {
        ResourceOwnerPasswordResourceDetails realDetails = new ResourceOwnerPasswordResourceDetails();
        realDetails.setId(id);
        realDetails.setClientId(clientId);
        realDetails.setAccessTokenUri(accessTokenUri);
        realDetails.setClientSecret(clientSecret);
        realDetails.setScope(Arrays.asList(scope));
        realDetails.setUsername(username);
        realDetails.setPassword(password);
        return realDetails;
    }
}
