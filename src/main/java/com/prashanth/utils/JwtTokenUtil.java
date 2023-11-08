package com.prashanth.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static com.prashanth.constants.CommonConstants.EXPIRATION_TIME;

@Component
@Slf4j
public class JwtTokenUtil {

    private final Key secreteKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    //1 minute expiration time

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secreteKey)
                .compact();
    }
    public String validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secreteKey)
                    .build()
                    .parseClaimsJws(token);
            return "valid";
        } catch (ExpiredJwtException ex) {
            log.info("expired token");
            // Token is expired
            return "expired token";
        } catch (JwtException | IllegalArgumentException e) {
            log.info("invalid token");
            // Token is invalid (failed parsing or verification)
            return "invalid token";
        }
    }
}
