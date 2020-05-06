package ru.kpfu.itis.demo.blog.rest.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.kpfu.itis.demo.blog.impl.service.UserServiceDB;
import ru.kpfu.itis.demo.blog.rest.exception.InvalidJwtAuthenticationException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtTokenProvider {

    private final UserServiceDB userServiceDB;
    private final JwtProperties jwtProperties;

    public JwtTokenProvider(UserServiceDB userServiceDB, JwtProperties jwtProperties) {
        this.userServiceDB = userServiceDB;
        this.jwtProperties = jwtProperties;
    }

    public Optional<Authentication> authenticate(HttpServletRequest servletRequest) throws InvalidJwtAuthenticationException {
        String token = resolveToken(servletRequest);
        if (StringUtils.hasText(token)) {
            try {
                Jws<Claims> claims = Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token);

                UserDetails userDetails = userServiceDB.loadUserByUsername(claims.getBody().getSubject());

                if (userDetails == null) return Optional.empty();

                return Optional.of(new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
            } catch (JwtException | IllegalArgumentException e) {
                throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
            }
        }
        return Optional.empty();
    }

    private String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtProperties.getValidity());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }
}
