package org.tecky.mvcwebcommon;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomJWTAuthenticationToken extends AbstractAuthenticationToken {
    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */


    private Integer uid;

    private String jwt;


    public CustomJWTAuthenticationToken(Integer uid, String jwt, Collection<? extends GrantedAuthority> authorities) {

        super(authorities);

        this.uid = uid;
        this.jwt = jwt;
    }

    @Override
    public Object getCredentials() {
        return this.jwt;
    }

    @Override
    public Object getPrincipal() {
        return this.uid;
    }
}
