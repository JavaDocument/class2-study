package com.example.springbootstudy2023.global.utils;

import com.example.springbootstudy2023.account.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    @Value("${jwt.secret}")
    private static String SECRET_KEY;
    @Value("${jwt.expire}")
    private static long EXPIRE_TIME;

    public static String generateToken(Account account) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .subject(String.valueOf(account.getId()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000))
                .signWith(key)
                .compact();
    }

    public static Claims extractClaims(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        Claims payload = Jwts.parser()
                .decryptWith(key)
                .build().parseSignedClaims(token).getPayload();

        if (payload == null) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }

        return payload;
    }

}
