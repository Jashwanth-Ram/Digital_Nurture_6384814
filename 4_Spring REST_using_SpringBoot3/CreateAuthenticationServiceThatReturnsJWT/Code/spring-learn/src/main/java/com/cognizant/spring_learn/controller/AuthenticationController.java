package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start: authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End: authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Start: getUser()");
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        String username = decodedString.split(":")[0];
        LOGGER.debug("Decoded Username: {}", username);
        LOGGER.debug("End: getUser()");
        return username;
    }

    private String generateJwt(String user) {
        LOGGER.debug("Start: generateJwt()");

        // Secure signing key for HS256
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        JwtBuilder builder = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 mins
                .signWith(key);

        String token = builder.compact();
        LOGGER.debug("Generated Token: {}", token);
        LOGGER.debug("End: generateJwt()");
        return token;
    }
}
