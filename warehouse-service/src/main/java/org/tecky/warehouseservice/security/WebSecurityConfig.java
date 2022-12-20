package org.tecky.warehouseservice.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.tecky.mvcwebcommon.filter.JWTFilter;

@Configuration
public class WebSecurityConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    public OncePerRequestFilter oncePerRequestFilter(){

        return new JWTFilter(this.jwtSecret);
    }

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .cors()
                .and()
                .authorizeRequests()

                .anyRequest().permitAll();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(oncePerRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
