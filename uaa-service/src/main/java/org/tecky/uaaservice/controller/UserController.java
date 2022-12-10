package org.tecky.uaaservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.jwt.JwtToken;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;
import org.tecky.uaaservice.entities.UserEntity;
import org.tecky.uaaservice.security.services.JwtResponseImpl;
import org.tecky.uaaservice.services.impl.UserDetailsServiceImpl;
import org.tecky.uaaservice.services.intf.IRegService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/auth")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private IRegService iRegService;

    @Value("${jwt.secret}")
    private String secret;


    @GetMapping(value = "/hello")
    public String hello() {

        return "hello";
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> register(@RequestBody Map<String, String> userInfo, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        log.info("register");

        if(request.getHeader("client_id") == null) {

            throw new CustomException(403, "Client ID is required in headers");
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setClientId(request.getHeader("client_id"));
        userEntity.setUsername(userInfo.get("username"));
        userEntity.setShapassword(userInfo.get("password"));
        userEntity.setEmail(userInfo.get("email"));

        iRegService.regNewUser(userEntity);

        return login(userInfo, request, response);
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody Map<String, String> userInfo, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

        log.info("authLogin");

        if(request.getHeader("client_id") == null) {

            throw new CustomException(403, "Client ID is required in headers");
        }

        authenticate(userInfo.get("username"), userInfo.get("password"), request);

        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userInfo.get("username"));

        JwtToken jwtToken = new JwtToken(this.secret);

        jwtToken.setPayload("client_id", request.getHeader("client_id"));
        jwtToken.setPayload("username", userDetails.getUsername());
        jwtToken.setPayload("authorize", userDetails.getAuthorities());

        JwtResponseImpl token = new JwtResponseImpl(jwtToken.generateToken());
        return ResponseObject
                .builder()
                .setPayLoad("Authorization", token.getToken())
                .setPayLoad("username", userDetails.getUsername())
                .setPayLoad("role", Optional.of(userDetails.getAuthorities()).get().toString())
                .create(200);

    }

    private void authenticate(String username, String password, HttpServletRequest request) {
        try {
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (DisabledException e) {

            throw new CustomException(401, "Username or password incorrect");

        } catch (BadCredentialsException e) {

            throw new CustomException(401, "User is not authorized");
        }
    }
}
