package com.example.nuevowhatsapp.model;

public class StatusList {
    private String userID;
    private String userName;
    private String date;
    private String urlStatus;

    public StatusList() {
    }

    public StatusList(String userID, String userName, String date, String urlStatus) {
        this.userID = userID;
        this.userName = userName;
        this.date = date;
        this.urlStatus = urlStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlStatus() {
        return urlStatus;
    }

    public void setUrlStatus(String urlStatus) {
        this.urlStatus = urlStatus;
    }
}
