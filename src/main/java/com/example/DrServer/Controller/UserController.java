package com.example.DrServer.Controller;

import com.example.DrServer.Entity.UserEntity;
import com.example.DrServer.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/member")
@RestController
public class UserController {
    @Autowired
    private UserRepo drHolmesRepo;

    @RequestMapping(value = "/select",
            method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public List<UserEntity> selectAll(){
        return drHolmesRepo.findAll();
    }

    @RequestMapping(value = "/insert",
            method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
            produces = "application/json; charset=utf-8")
    public UserEntity insert(@RequestBody Map<String, String> map) {
        return drHolmesRepo.save(new UserEntity(map.get("userId"), map.get("userPassword"), map.get("userName"),
                map.get("userBirth"), map.get("userGender"), map.get("emailAgree"), map.get("joinDate"))
        );
    }
}


//RequestMethod.PUT, RequestMethod.DELETE -> 추가함

