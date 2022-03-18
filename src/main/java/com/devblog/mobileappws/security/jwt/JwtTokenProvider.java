package com.devblog.mobileappws.security.jwt;

import com.devblog.mobileappws.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        Date expirationDate = getExpirationDate(token);
        return expirationDate.before(new Date(System.currentTimeMillis()));
    }

    public String getUsername(String token) {
        return getClaims(token, Claims::getSubject);
    }

    public Date getExpirationDate(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    private <T> T getClaims(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        return resolver.apply(claims);
    }
}
