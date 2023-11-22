package com.practice.lkdcode.global.config.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@ConfigurationProperties(prefix = "app.jwt")
//@ConfigurationPropertiesBinding
//@ConfigurationPropertiesScan
@Getter
@Setter
public class JWTProperties {
    private String issuer;
    private String secretKey;
    private Long expired;

    public Key getSecretKey() {
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(secretKey);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }
}
