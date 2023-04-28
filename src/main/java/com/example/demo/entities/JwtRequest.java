package com.example.demo.entities;


public class JwtRequest {

    private String username;
    private String mdp;

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getUserPassword() {
        return mdp;
    }

    public void setUserPassword(String userPassword) {
        this.mdp = userPassword;
    }
}