package com.freelance.bitcoin.security.config;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * PBKDF2PasswordEncoder : Password-Based Key Derivation Function dùng để mã hóa passowrd thông qua 1 key 
 * Đọc hiểu tại: https://huongdandaotienao.com/pbkdf2-la-gi/
*/
@Component
public class PBKDF2PasswordEncoder implements PasswordEncoder {

    @Value("${spring.jjwt.secret}")
    private String secrectKey;

    @Value("${spring.jjwt.salt}")
    private int iteration;

    @Value("${spring.jjwt.keylength}")
    private int keyLength;

    // mã hóa
    @Override
    public String encode(CharSequence cs) {
        try {
            byte[] raw = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secrectKey.getBytes(), iteration, keyLength))
                    .getEncoded();
            String passwordEncoded = Base64.getEncoder().encodeToString(raw);

            return passwordEncoded;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    // check password encoder
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}