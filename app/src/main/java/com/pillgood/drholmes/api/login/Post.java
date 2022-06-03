package com.pillgood.drholmes.api.login;

import com.google.gson.annotations.SerializedName;

public class Post {

//    String userId;
//    String userPassword;
//    String userName;
//    String userBirth;
//    String userGender;
//    Integer emailAgree;
//    String joinDate;
//
//    public Post(String userId, String userPassword) {
//        this.userId = userId;
//        this.userPassword = userPassword;
//    }
//
//    public String getId() {
//        return userId;
//    }
//
//    public String getPassword() {
//        return userPassword;
//    }
//
//    public String getName() {
//        return userName;
//    }
//
//    public String getBirth() {
//        return userBirth;
//    }
//
//    public String getGender() {
//        return userGender;
//    }
//
//    public Integer getEmailAgree() {
//        return emailAgree;
//    }
//
//    public String getJoinDate() {
//        return joinDate;
//    }

    public Post(String id, String pw) {
        this.userId = id;
        this.userPassword = pw;
        this.userName = "id";
        this.userBirth = "pw";
        this.userGender = "id";
        this.emailAgree = "pw";
        this.joinDate = "id";
    }

    @SerializedName("userId") private String userId;
    @SerializedName("userPassword") private String userPassword;
    @SerializedName("userName") private String userName;
    @SerializedName("userBirth") private String userBirth;
    @SerializedName("userGender") private String userGender;
    @SerializedName("emailAgree") private String emailAgree;
    @SerializedName("joinDate") private String joinDate;

}
