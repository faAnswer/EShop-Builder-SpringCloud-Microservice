package org.tecky.mvcwebcommon.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.jwt.JWTUtil;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.tecky.mvcwebcommon.CustomJWTAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Slf4j
public class JWTCustomFilter extends AbstractAuthenticationProcessingFilter {

    protected JWTCustomFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    private Pattern pattern = Pattern.compile("(?<=Bearer\\s).*");

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String jwtToken = request.getHeader("Authorization");

        if (jwtToken == null) {

            throw new AuthenticationServiceException("JWT Token Not Found");
        }

        Matcher matcher = pattern.matcher(jwtToken);

        while(matcher.find()){

            jwtToken = matcher.group();
        }

        if (jwtToken == null) {

            throw new AuthenticationServiceException("Authorization format is incorrect");
        }

        Integer uid = null;
        ArrayList<String> authorizeList = null;

        uid = (Integer) JWTUtil.getPayload(jwtToken, "uid");
        authorizeList = (ArrayList<String>) JWTUtil.getPayload(jwtToken, "username");

        if (uid == null || authorizeList == null) {

            throw new AuthenticationServiceException("Username not found in JWT");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String auth : authorizeList) {

            authorities.add(new SimpleGrantedAuthority(auth));
        }

        return this.getAuthenticationManager().authenticate(new CustomJWTAuthenticationToken(uid, jwtToken, authorities));

    }
}