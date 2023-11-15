package com.example.springbootstudy2023.account.utils;

import com.example.springbootstudy2023.account.entity.Account;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

public class JwtUtil {

    @Value("${jwt.secret}")
    private static String SECRET_KEY;
    @Value("${jwt.expire}")
    private static long EXPIRE_TIME;

    public static String generateToken(Account account) {
        HashMap<String, Object> claims = new HashMap<>();
        return createToken(claims, account.getId());
    }

    // TODO: jjwt 라이브러리 사용 방법 알아서 토큰 생성

    private static String createToken(HashMap<String, Object> claims, Long id) {
        return null;
    }

}
