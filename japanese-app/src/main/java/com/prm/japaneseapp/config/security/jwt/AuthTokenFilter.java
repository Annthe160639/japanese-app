package com.prm.japaneseapp.config.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Component
@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = parseJwt(request);

        Optional<Authentication> authentication = this.createAuthentication(token);

        authentication.ifPresent(value ->
                SecurityContextHolder.getContext().setAuthentication(value));

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }

    public Optional<Authentication> createAuthentication(String token) {

        Jws<Claims> jwsClaims = validateToken(token);
        if (jwsClaims == null) {
            log.info("null jwsClaims");
            return Optional.empty();
        }

        Claims claims = jwsClaims.getBody();
        String rolesString = claims.get("scope").toString();

        String[] authStrings = rolesString.replaceAll("[\\[\\]\\s]+", "").trim().split(",");

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(authStrings)
                        .map(SimpleGrantedAuthority::new)
                        .toList();

        String subject = claims.getSubject();
        org.springframework.security.core.userdetails.User principal = new User(subject, "", authorities);

        return Optional.of(new UsernamePasswordAuthenticationToken(principal, token, authorities));
    }

    public Jws<Claims> validateToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            log.error("JWT accessToken is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT accessToken is unsupported: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT accessToken: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return null;
    }

}
