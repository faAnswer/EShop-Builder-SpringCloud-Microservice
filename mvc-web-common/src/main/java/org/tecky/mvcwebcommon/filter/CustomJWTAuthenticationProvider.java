package org.tecky.mvcwebcommon.filter;

import org.faAnswer.jwt.JWTUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.tecky.mvcwebcommon.CustomJWTAuthenticationToken;

public class CustomJWTAuthenticationProvider implements AuthenticationProvider {

    private String secret;

    public CustomJWTAuthenticationProvider(String secret){


        this.secret = secret;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomJWTAuthenticationToken customJWTAuthenticationToken = (CustomJWTAuthenticationToken) authentication;

        String jwt = (String) customJWTAuthenticationToken.getCredentials();

        if(!JWTUtil.valid(this.secret, jwt) || !JWTUtil.validDate(this.secret, jwt)){

            throw new BadCredentialsException("Invalid JWT");
        }

        customJWTAuthenticationToken.setAuthenticated(true);

        return customJWTAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return CustomJWTAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
