package com.pillgood.drholmes.api.login;

public class Post {

    String userId;
    String userPassword;
    String userName;
    String userBirth;
    String userGender;
    Integer emailAgree;
    String joinDate;

    public String getId() {
        return userId;
    }

    public String getPassword() {
        return userPassword;
    }

    public String getName() {
        return userName;
    }

    public String getBirth() {
        return userBirth;
    }

    public String getGender() {
        return userGender;
    }

    public Integer getEmailAgree() {
        return emailAgree;
    }

    public String getJoinDate() {
        return joinDate;
    }
}
