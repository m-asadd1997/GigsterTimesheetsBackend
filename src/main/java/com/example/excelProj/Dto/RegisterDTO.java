package com.example.excelProj.Dto;

public class RegisterDTO {

    private String email;
    private String password;
    private String organizationName;

    public RegisterDTO(String email, String password, String organizationName) {
        this.email = email;
        this.password = password;
        this.organizationName = organizationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
