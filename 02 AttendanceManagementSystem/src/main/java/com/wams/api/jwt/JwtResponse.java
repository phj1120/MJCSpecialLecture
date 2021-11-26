package com.wams.api.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    
//    getToken 있어야지 로그인시 json 형태로 Response 가능
    public String getToken() {
        return this.jwttoken;
    }
}