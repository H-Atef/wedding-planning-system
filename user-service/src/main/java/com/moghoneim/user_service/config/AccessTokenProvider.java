package com.moghoneim.user_service.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenProvider {

    public String getAccessToken() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof BearerTokenAuthentication bearerToken) {
            System.out.println(bearerToken.getToken().getTokenValue());
            return bearerToken.getToken().getTokenValue();
        }

        return null;
    }
}

