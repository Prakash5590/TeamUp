package com.oauth2.sso.dto;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {
    private String jwtToken;
    private String response;

    public JwtTokenResponse(String jwtToken, String response) {
        this.jwtToken = jwtToken;
        this.response = response;
    }
}
