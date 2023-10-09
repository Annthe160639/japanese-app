package com.prm.japaneseapp.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long expirationTime;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        String username = decodeTokenAndGetUsername(token);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, null, null);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return authenticationToken;
    }
    public String decodeTokenAndGetUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey) // Thay thế secretKey bằng khóa bí mật của bạn
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey) // Replace secretKey with your secret key
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Handle token validation failure
            log.error("Error validating token: " + e.getMessage());
            return false;
        }
    }
}