package com.practice.lkdcode.global.config.jwt;

import com.practice.lkdcode.global.config.security.CustomUserDetails;
import com.practice.lkdcode.module.user.domain.User;
import com.practice.lkdcode.support.base.BaseRepositoryList;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.security.Key;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class JWTProviderTest extends BaseRepositoryList {
    @Mock
    private JWTProperties jwtProperties;
    @InjectMocks
    private JWTProvider jwtProvider;
    private User user;

    @BeforeEach
    void setUp() {
        this.user = super.userRepository.findById(USER_ID).orElseThrow();
        // Mocking JWTProperties behavior
        when(jwtProperties.getIssuer()).thenReturn("example-issuer");

        // 안전한 키 생성 방법으로 변경
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        when(jwtProperties.getSecretKey()).thenReturn(secretKey);
        when(jwtProperties.getExpired()).thenReturn(20_000L); // 원하는 만료 시간 설정
    }

    @Test
    void 토큰_생성_성공_테스트() {
        // given
        // when
        String token = jwtProvider.generateToken(user);

        // then
        assertThat(token)
                .isNotNull();
    }

    @Test
    void 유효한_토큰_검증_성공_테스트() {
        // given
        String token = makeToken();

        // when
        boolean validateToken = jwtProvider.validateToken(token);

        // then
        assertThat(validateToken)
                .isTrue();
    }

    @Test
    void 유효한_토큰에서_유저_아이디_취득_성공_테스트() {
        // given
        String token = makeToken();

        // when
        CustomUserDetails customUserDetails = jwtProvider.getCustomUserDetails(token);

        // then
        assertThat(customUserDetails.getId())
                .isEqualTo(USER_ID);
    }

    private String makeToken() {
        return jwtProvider.generateToken(user);
    }
}