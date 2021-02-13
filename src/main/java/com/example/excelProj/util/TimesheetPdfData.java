package com.example.excelProj.util;

public class TimesheetPdfData {

    private String day;
    private String startTime;
    private String endTime;
    private String overtime;
    private String hours;
    private String breakTime;

    public TimesheetPdfData() {
    }

    public TimesheetPdfData(String day, String startTime, String endTime, String overtime, String hours, String breakTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.overtime = overtime;
        this.hours = hours;
        this.breakTime = breakTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }
}
