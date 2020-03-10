package com.example.excelProj.Dto;

public class CompanyProfileDTO {

    private String companyName;
    private String corporateAddress;
    private String billingAddress;
    private String contactName;
    private String contactTitle;
    private String roles;
    private String startingDayOfWeek;
    private byte[] companyimage;

    public CompanyProfileDTO() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCorporateAddress() {
        return corporateAddress;
    }

    public void setCorporateAddress(String corporateAddress) {
        this.corporateAddress = corporateAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getStartingDayOfWeek() {
        return startingDayOfWeek;
    }

    public void setStartingDayOfWeek(String startingDayOfWeek) {
        this.startingDayOfWeek = startingDayOfWeek;
    }

    public byte[] getCompanyimage() {
        return companyimage;
    }

    public void setCompanyimage(byte[] companyimage) {
        this.companyimage = companyimage;
    }
}
