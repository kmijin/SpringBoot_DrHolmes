package com.example.DrServer.Repo;

import com.example.DrServer.Entity.PillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillRepo extends JpaRepository<PillEntity, String> {

}
