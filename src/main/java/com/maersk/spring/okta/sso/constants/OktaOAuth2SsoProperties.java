package com.maersk.spring.okta.sso.constants;

public class OktaOAuth2SsoProperties {

        public static final String OKTA_OAUTH2_REST_TEMPLATE = "OKTA_OAUTH2_REST_TEMPLATE";
        public static final String RESOURCE_DETAILS_USERNAME_PROPERTIES = "${okta.oauth2.client.username}";
        public static final String RESOURCE_DETAILS_PASSWORD_PROPERTIES = "${okta.oauth2.client.password}";
        public static final String RESOURCE_DETAILS_ID_PROPERTIES = "${okta.oauth2.client.id}";
        public static final String RESOURCE_DETAILS_CLIENT_ID_PROPERTIES = "${okta.oauth2.client.client-id}";
        public static final String RESOURCE_DETAILS_CLIENT_SECRET_PROPERTIES = "${okta.oauth2.client.client-secret}";
        public static final String RESOURCE_DETAILS_ACCESS_TOKEN_URI_PROPERTIES = "${okta.oauth2.client.access-token-uri}";
        public static final String RESOURCE_DETAILS_SCOPE_PROPERTIES = "${okta.oauth2.client.scope}";
}
