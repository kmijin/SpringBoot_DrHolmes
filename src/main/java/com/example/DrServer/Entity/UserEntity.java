package com.example.DrServer.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //추
public class UserEntity {
    @Id //추
    private String userId;
    private String userPassword;
    private String userName;
    private String userBirth;
    private String userGender;
    private String emailAgree;
    private String joinDate;

    public UserEntity() {
    }

    public UserEntity(String userId, String userPassword, String userName, String userBirth, String userGender, String emailAgree, String joinDate) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.emailAgree = emailAgree;
        this.joinDate = joinDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getEmailAgree() {
        return emailAgree;
    }

    public void setEmailAgree(String emailAgree) {
        this.emailAgree = emailAgree;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
