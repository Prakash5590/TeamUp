package com.oauth2.sso.service;

import com.oauth2.sso.dto.JwtTokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenService {

    private final String secret = "n2r5u8x!A%D*G-KaPdSgVkYp3s6v9y$B?E(H+MbQeThWmZq4t7w!z%C*F)J@NcRf";
    private final long expiry = 5*60*1000;    //Expires in 5 minute
    public JwtTokenResponse generateToken( String userName ){
        Map<String, Object> claims = new HashMap<>();
        return new JwtTokenResponse(createToken(claims, userName), "Login Successful and Token generate.");
    }

    private String createToken(Map<String, Object> claims, String userName) {
        String tok = Jwts.builder().setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith( SignatureAlgorithm.HS512, getSecretKey())
                .compact();
        System.out.println("----->"+tok);
        return tok;
    }

    private byte[] getSecretKey() {
        return Base64Codec.BASE64.decode(secret);
    }
}
