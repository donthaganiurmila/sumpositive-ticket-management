package com.example.projectmanagementtool.dto;

public class AuthResponse {

    private String message;
    private String token;
    private String tokenType;

    public AuthResponse(){}
    public AuthResponse(String message,String token,String tokenType){
        this.message=message;
        this.token=token;
        this.tokenType=tokenType;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }
}
