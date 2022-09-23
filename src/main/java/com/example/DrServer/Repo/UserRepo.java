package com.example.DrServer.Repo;

import com.example.DrServer.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//추가
@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
}
