package com.example.excelProj.Commons;

public enum EmailTemplate {
    REGISTER_EMAIL("email-templates/register-email-template.html"),
    DYNAMIC_EMAIL("email-templates/dynamic-email-template.html");

    String path;

    EmailTemplate(String path){
        this.path=path;
    }

    public String getPath(){
        return this.path;
    }

}
