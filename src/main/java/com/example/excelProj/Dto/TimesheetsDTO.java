package com.example.excelProj.Dto;

import com.example.excelProj.Model.User;

public class TimesheetsDTO {

    private Long weekId;
    private String mondayStartTime;
    private String mondayEndTime;
    private String tuesdayStartTime;
    private String tuesdayEndTime;
    private String wednesdayStartTime;
    private String wednesdayEndTime;
    private String thursdayStartTime;
    private String thursdayEndTime;
    private String fridayStartTime;
    private String fridayEndTime;
    private String saturdayStartTime;
    private String saturdayEndTime;
    private String sundayStartTime;
    private String sundayEndTime;
    private String status;
    private User user;
    private User supervisor;
    private String dateSubmitted;
    private String sendFlag;
    private String comments;
    private String monTotalHrs;
    private String tueTotalHrs;
    private String wedTotalHrs;
    private String thursTotalHrs;
    private String friTotalHrs;
    private String satTotalHrs;
    private String sunTotalHrs;
    private String totalHrs;
    private String monExtraHrs;
    private String tueExtraHrs;
    private String wedExtraHrs;
    private String thursExtraHrs;
    private String friExtraHrs;
    private String satExtraHrs;
    private String sunExtraHrs;
    private String monBreakTime;
    private String tueBreakTime;
    private String wedBreakTime;
    private String thursBreakTime;
    private String friBreakTime;
    private String satBreakTime;
    private String sunBreakTime;

    public TimesheetsDTO() {
    }

    public TimesheetsDTO(Long weekId, String mondayStartTime, String mondayEndTime, String tuesdayStartTime, String tuesdayEndTime, String wednesdayStartTime, String wednesdayEndTime, String thursdayStartTime, String thursdayEndTime, String fridayStartTime, String fridayEndTime, String saturdayStartTime, String saturdayEndTime, String sundayStartTime, String sundayEndTime, String status, User user, User supervisor, String dateSubmitted, String sendFlag, String comments, String monTotalHrs, String tueTotalHrs, String wedTotalHrs, String thursTotalHrs, String friTotalHrs, String satTotalHrs, String sunTotalHrs, String totalHrs, String monExtraHrs, String tueExtraHrs, String wedExtraHrs, String thursExtraHrs, String friExtraHrs, String satExtraHrs, String sunExtraHrs, String monBreakTime, String tueBreakTime, String wedBreakTime, String thursBreakTime, String friBreakTime, String satBreakTime, String sunBreakTime) {
        this.weekId = weekId;
        this.mondayStartTime = mondayStartTime;
        this.mondayEndTime = mondayEndTime;
        this.tuesdayStartTime = tuesdayStartTime;
        this.tuesdayEndTime = tuesdayEndTime;
        this.wednesdayStartTime = wednesdayStartTime;
        this.wednesdayEndTime = wednesdayEndTime;
        this.thursdayStartTime = thursdayStartTime;
        this.thursdayEndTime = thursdayEndTime;
        this.fridayStartTime = fridayStartTime;
        this.fridayEndTime = fridayEndTime;
        this.saturdayStartTime = saturdayStartTime;
        this.saturdayEndTime = saturdayEndTime;
        this.sundayStartTime = sundayStartTime;
        this.sundayEndTime = sundayEndTime;
        this.status = status;
        this.user = user;
        this.supervisor = supervisor;
        this.dateSubmitted = dateSubmitted;
        this.sendFlag = sendFlag;
        this.comments = comments;
        this.monTotalHrs = monTotalHrs;
        this.tueTotalHrs = tueTotalHrs;
        this.wedTotalHrs = wedTotalHrs;
        this.thursTotalHrs = thursTotalHrs;
        this.friTotalHrs = friTotalHrs;
        this.satTotalHrs = satTotalHrs;
        this.sunTotalHrs = sunTotalHrs;
        this.totalHrs = totalHrs;
        this.monExtraHrs = monExtraHrs;
        this.tueExtraHrs = tueExtraHrs;
        this.wedExtraHrs = wedExtraHrs;
        this.thursExtraHrs = thursExtraHrs;
        this.friExtraHrs = friExtraHrs;
        this.satExtraHrs = satExtraHrs;
        this.sunExtraHrs = sunExtraHrs;
        this.monBreakTime = monBreakTime;
        this.tueBreakTime = tueBreakTime;
        this.wedBreakTime = wedBreakTime;
        this.thursBreakTime = thursBreakTime;
        this.friBreakTime = friBreakTime;
        this.satBreakTime = satBreakTime;
        this.sunBreakTime = sunBreakTime;
    }

    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        this.weekId = weekId;
    }

    public String getMondayStartTime() {
        return mondayStartTime;
    }

    public void setMondayStartTime(String mondayStartTime) {
        this.mondayStartTime = mondayStartTime;
    }

    public String getMondayEndTime() {
        return mondayEndTime;
    }

    public void setMondayEndTime(String mondayEndTime) {
        this.mondayEndTime = mondayEndTime;
    }

    public String getTuesdayStartTime() {
        return tuesdayStartTime;
    }

    public void setTuesdayStartTime(String tuesdayStartTime) {
        this.tuesdayStartTime = tuesdayStartTime;
    }

    public String getTuesdayEndTime() {
        return tuesdayEndTime;
    }

    public void setTuesdayEndTime(String tuesdayEndTime) {
        this.tuesdayEndTime = tuesdayEndTime;
    }

    public String getWednesdayStartTime() {
        return wednesdayStartTime;
    }

    public void setWednesdayStartTime(String wednesdayStartTime) {
        this.wednesdayStartTime = wednesdayStartTime;
    }

    public String getWednesdayEndTime() {
        return wednesdayEndTime;
    }

    public void setWednesdayEndTime(String wednesdayEndTime) {
        this.wednesdayEndTime = wednesdayEndTime;
    }

    public String getThursdayStartTime() {
        return thursdayStartTime;
    }

    public void setThursdayStartTime(String thursdayStartTime) {
        this.thursdayStartTime = thursdayStartTime;
    }

    public String getThursdayEndTime() {
        return thursdayEndTime;
    }

    public void setThursdayEndTime(String thursdayEndTime) {
        this.thursdayEndTime = thursdayEndTime;
    }

    public String getFridayStartTime() {
        return fridayStartTime;
    }

    public void setFridayStartTime(String fridayStartTime) {
        this.fridayStartTime = fridayStartTime;
    }

    public String getFridayEndTime() {
        return fridayEndTime;
    }

    public void setFridayEndTime(String fridayEndTime) {
        this.fridayEndTime = fridayEndTime;
    }

    public String getSaturdayStartTime() {
        return saturdayStartTime;
    }

    public void setSaturdayStartTime(String saturdayStartTime) {
        this.saturdayStartTime = saturdayStartTime;
    }

    public String getSaturdayEndTime() {
        return saturdayEndTime;
    }

    public void setSaturdayEndTime(String saturdayEndTime) {
        this.saturdayEndTime = saturdayEndTime;
    }

    public String getSundayStartTime() {
        return sundayStartTime;
    }

    public void setSundayStartTime(String sundayStartTime) {
        this.sundayStartTime = sundayStartTime;
    }

    public String getSundayEndTime() {
        return sundayEndTime;
    }

    public void setSundayEndTime(String sundayEndTime) {
        this.sundayEndTime = sundayEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMonTotalHrs() {
        return monTotalHrs;
    }

    public void setMonTotalHrs(String monTotalHrs) {
        this.monTotalHrs = monTotalHrs;
    }

    public String getTueTotalHrs() {
        return tueTotalHrs;
    }

    public void setTueTotalHrs(String tueTotalHrs) {
        this.tueTotalHrs = tueTotalHrs;
    }

    public String getWedTotalHrs() {
        return wedTotalHrs;
    }

    public void setWedTotalHrs(String wedTotalHrs) {
        this.wedTotalHrs = wedTotalHrs;
    }

    public String getThursTotalHrs() {
        return thursTotalHrs;
    }

    public void setThursTotalHrs(String thursTotalHrs) {
        this.thursTotalHrs = thursTotalHrs;
    }

    public String getFriTotalHrs() {
        return friTotalHrs;
    }

    public void setFriTotalHrs(String friTotalHrs) {
        this.friTotalHrs = friTotalHrs;
    }

    public String getSatTotalHrs() {
        return satTotalHrs;
    }

    public void setSatTotalHrs(String satTotalHrs) {
        this.satTotalHrs = satTotalHrs;
    }

    public String getSunTotalHrs() {
        return sunTotalHrs;
    }

    public void setSunTotalHrs(String sunTotalHrs) {
        this.sunTotalHrs = sunTotalHrs;
    }

    public String getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(String totalHrs) {
        this.totalHrs = totalHrs;
    }

    public String getMonExtraHrs() {
        return monExtraHrs;
    }

    public void setMonExtraHrs(String monExtraHrs) {
        this.monExtraHrs = monExtraHrs;
    }

    public String getTueExtraHrs() {
        return tueExtraHrs;
    }

    public void setTueExtraHrs(String tueExtraHrs) {
        this.tueExtraHrs = tueExtraHrs;
    }

    public String getWedExtraHrs() {
        return wedExtraHrs;
    }

    public void setWedExtraHrs(String wedExtraHrs) {
        this.wedExtraHrs = wedExtraHrs;
    }

    public String getThursExtraHrs() {
        return thursExtraHrs;
    }

    public void setThursExtraHrs(String thursExtraHrs) {
        this.thursExtraHrs = thursExtraHrs;
    }

    public String getFriExtraHrs() {
        return friExtraHrs;
    }

    public void setFriExtraHrs(String friExtraHrs) {
        this.friExtraHrs = friExtraHrs;
    }

    public String getSatExtraHrs() {
        return satExtraHrs;
    }

    public void setSatExtraHrs(String satExtraHrs) {
        this.satExtraHrs = satExtraHrs;
    }

    public String getSunExtraHrs() {
        return sunExtraHrs;
    }

    public void setSunExtraHrs(String sunExtraHrs) {
        this.sunExtraHrs = sunExtraHrs;
    }

    public String getMonBreakTime() {
        return monBreakTime;
    }

    public void setMonBreakTime(String monBreakTime) {
        this.monBreakTime = monBreakTime;
    }

    public String getTueBreakTime() {
        return tueBreakTime;
    }

    public void setTueBreakTime(String tueBreakTime) {
        this.tueBreakTime = tueBreakTime;
    }

    public String getWedBreakTime() {
        return wedBreakTime;
    }

    public void setWedBreakTime(String wedBreakTime) {
        this.wedBreakTime = wedBreakTime;
    }

    public String getThursBreakTime() {
        return thursBreakTime;
    }

    public void setThursBreakTime(String thursBreakTime) {
        this.thursBreakTime = thursBreakTime;
    }

    public String getFriBreakTime() {
        return friBreakTime;
    }

    public void setFriBreakTime(String friBreakTime) {
        this.friBreakTime = friBreakTime;
    }

    public String getSatBreakTime() {
        return satBreakTime;
    }

    public void setSatBreakTime(String satBreakTime) {
        this.satBreakTime = satBreakTime;
    }

    public String getSunBreakTime() {
        return sunBreakTime;
    }

    public void setSunBreakTime(String sunBreakTime) {
        this.sunBreakTime = sunBreakTime;
    }
}
