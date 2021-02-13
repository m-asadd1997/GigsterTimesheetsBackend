package com.example.excelProj.Commons;

public class AuthToken {

    private Long id;
    private String token;
    private String username;
    private String userType;
    private  String email;
    private String organizationName;
    private byte[] userImage;
    private Boolean paid;

    public AuthToken(String token, String username, String userType) {
        this.token = token;
        this.username = username;
        this.userType = userType;
    }

    public AuthToken(String token, String username, String userType, String email) {
        this.token = token;
        this.username = username;
        this.userType = userType;
        this.email = email;
    }

    public AuthToken(String token, String username, String userType, String email,String organizationName) {
        this.token = token;
        this.username = username;
        this.userType = userType;
        this.email = email;
        this.organizationName = organizationName;
    }

    public AuthToken(Long id, String token, String username, String userType, String email, String organizationName) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.userType = userType;
        this.email = email;
        this.organizationName = organizationName;
    }

    public AuthToken(Long id, String token, String username, String userType, String email, String organizationName, byte[] userImage, Boolean paid) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.userType = userType;
        this.email = email;
        this.organizationName = organizationName;
        this.userImage = userImage;
        this.paid = paid;
    }

    public AuthToken(){

    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
