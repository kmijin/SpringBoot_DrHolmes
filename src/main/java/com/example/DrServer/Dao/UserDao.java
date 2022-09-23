package com.example.DrServer.Dao;

import com.example.DrServer.Entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    public static List<UserEntity> users;
    //임시 객체
    static {
        users = new ArrayList<>();
        users.add(new UserEntity("admin@gmail.com", "admin", "admin", "2001-08-08", "M", "Y", "2022-05-01"));
        users.add(new UserEntity("admin@gmail.com", "admin", "admin", "2001-08-08", "F", "Y", "2022-05-01"));
        users.add(new UserEntity("admin@gmail.com", "admin", "admin", "2001-08-08", "M", "Y", "2022-05-01"));
        users.add(new UserEntity("admin@gmail.com", "admin", "admin", "2001-08-08", "F", "Y", "2022-05-01"));
    }
    //모든 유저 조회
    public List<UserEntity> getAllUsers() {
        return users;
    }
    //유저 아이디 검색
    public UserEntity getUserByUserId(String userId) {
        return users
                .stream()
                .filter(userEntity -> userEntity.getUserId().equals(userId))
                .findAny()
                .orElse(new UserEntity("","","","","","",""));
    }
    //유저 생성
    public UserEntity insertUser(UserEntity userEntity) {
        users.add(userEntity);
        return userEntity;
    }
    //유저 수정
    public void updateUser(String userId, UserEntity userEntity){
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new UserEntity("","","","","","",""))
                .setUserName(userEntity.getUserName());
    }
    //유저 삭제
    public void deleteUser(String userId) {
        users.removeIf(userEntity -> userEntity.getUserId().equals(userId));
    }
}
