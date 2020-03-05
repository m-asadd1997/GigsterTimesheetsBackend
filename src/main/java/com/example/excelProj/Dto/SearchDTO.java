package com.example.excelProj.Dto;

public class SearchDTO {
    String name;
    String surname;
    String email;
    String status;
    String phoneNumber;
    String date;
    String checkinDate;
    String checkoutDate;
    String daysOfRental;
    Boolean oEmbassyGardens;
    Boolean oTheGallery;
    Boolean oTheResidence;
   Boolean oCliftonPlace;
    Boolean oCliftonCourt;
   Boolean oKaiVillas;
   Boolean oAddyVillas;
   Long total;
     Boolean oLennox;
    Boolean tLennox;
   Boolean tEmbassyGardens;
   Boolean tTheGallery;
   Boolean tTheResidence;
   Boolean tCliftonPlace;
   Boolean tCliftonCourt;
   Boolean tKaiVillas;
   Boolean tAddyVillas;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SearchDTO() {
    }

    public SearchDTO(String name, String email, String status, String phoneNumber, String date, Boolean oEmbassyGardens, Boolean oTheGallery, Boolean oTheResidence, Boolean oCliftonPlace, Boolean oCliftonCourt, Boolean oKaiVillas, Boolean oAddyVillas, Long total, Boolean oLennox, Boolean tLennox, Boolean tEmbassyGardens, Boolean tTheGallery, Boolean tTheResidence, Boolean tCliftonPlace, Boolean tCliftonCourt, Boolean tKaiVillas, Boolean tAddyVillas) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.oEmbassyGardens = oEmbassyGardens;
        this.oTheGallery = oTheGallery;
        this.oTheResidence = oTheResidence;
        this.oCliftonPlace = oCliftonPlace;
        this.oCliftonCourt = oCliftonCourt;
        this.oKaiVillas = oKaiVillas;
        this.oAddyVillas = oAddyVillas;
        this.total = total;
        this.oLennox = oLennox;
        this.tLennox = tLennox;
        this.tEmbassyGardens = tEmbassyGardens;
        this.tTheGallery = tTheGallery;
        this.tTheResidence = tTheResidence;
        this.tCliftonPlace = tCliftonPlace;
        this.tCliftonCourt = tCliftonCourt;
        this.tKaiVillas = tKaiVillas;
        this.tAddyVillas = tAddyVillas;
    }

    public Boolean getoLennox() {
        return oLennox;
    }

    public void setoLennox(Boolean oLennox) {
        this.oLennox = oLennox;
    }

    public Boolean gettLennox() {
        return tLennox;
    }

    public void settLennox(Boolean tLennox) {
        this.tLennox = tLennox;
    }

    public Boolean getoEmbassyGardens() {
        return oEmbassyGardens;
    }

    public void setoEmbassyGardens(Boolean oEmbassyGardens) {
        this.oEmbassyGardens = oEmbassyGardens;
    }

    public Boolean getoTheGallery() {
        return oTheGallery;
    }

    public void setoTheGallery(Boolean oTheGallery) {
        this.oTheGallery = oTheGallery;
    }

    public Boolean getoTheResidence() {
        return oTheResidence;
    }

    public void setoTheResidence(Boolean oTheResidence) {
        this.oTheResidence = oTheResidence;
    }

    public Boolean getoCliftonPlace() {
        return oCliftonPlace;
    }

    public void setoCliftonPlace(Boolean oCliftonPlace) {
        this.oCliftonPlace = oCliftonPlace;
    }

    public Boolean getoCliftonCourt() {
        return oCliftonCourt;
    }

    public void setoCliftonCourt(Boolean oCliftonCourt) {
        this.oCliftonCourt = oCliftonCourt;
    }

    public Boolean getoKaiVillas() {
        return oKaiVillas;
    }

    public void setoKaiVillas(Boolean oKaiVillas) {
        this.oKaiVillas = oKaiVillas;
    }

    public Boolean getoAddyVillas() {
        return oAddyVillas;
    }

    public void setoAddyVillas(Boolean oAddyVillas) {
        this.oAddyVillas = oAddyVillas;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean gettEmbassyGardens() {
        return tEmbassyGardens;
    }

    public void settEmbassyGardens(Boolean tEmbassyGardens) {
        this.tEmbassyGardens = tEmbassyGardens;
    }

    public Boolean gettTheGallery() {
        return tTheGallery;
    }

    public void settTheGallery(Boolean tTheGallery) {
        this.tTheGallery = tTheGallery;
    }

    public Boolean gettTheResidence() {
        return tTheResidence;
    }

    public void settTheResidence(Boolean tTheResidence) {
        this.tTheResidence = tTheResidence;
    }

    public Boolean gettCliftonPlace() {
        return tCliftonPlace;
    }

    public void settCliftonPlace(Boolean tCliftonPlace) {
        this.tCliftonPlace = tCliftonPlace;
    }

    public Boolean gettCliftonCourt() {
        return tCliftonCourt;
    }

    public void settCliftonCourt(Boolean tCliftonCourt) {
        this.tCliftonCourt = tCliftonCourt;
    }

    public Boolean gettKaiVillas() {
        return tKaiVillas;
    }

    public void settKaiVillas(Boolean tKaiVillas) {
        this.tKaiVillas = tKaiVillas;
    }

    public Boolean gettAddyVillas() {
        return tAddyVillas;
    }

    public void settAddyVillas(Boolean tAddyVillas) {
        this.tAddyVillas = tAddyVillas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getDaysOfRental() {
        return daysOfRental;
    }

    public void setDaysOfRental(String daysOfRental) {
        this.daysOfRental = daysOfRental;
    }
}

