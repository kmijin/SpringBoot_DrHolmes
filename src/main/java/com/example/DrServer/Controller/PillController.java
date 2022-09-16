package com.example.DrServer.Controller;

import com.example.DrServer.Entity.PillEntity;
import com.example.DrServer.Repo.PillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PillController {
    @Autowired
    private PillRepo pillRepo;

    @PostMapping("/pill")
    public PillEntity createPill(@RequestBody PillEntity pillEntity){
        PillEntity created = pillRepo.save(pillEntity);
        return created;
    }

    @GetMapping("/pill")
    public List<PillEntity> listAllPills() {
        List<PillEntity> list = new ArrayList<>();
        Iterable<PillEntity> iterable = pillRepo.findAll();
        for (PillEntity pillEntity : iterable) {
            list.add(pillEntity);
        }
        return list;
    }

    @PutMapping("/pill/{State}")
    public PillEntity updatePill(@PathVariable("State") String State,
                                 @RequestBody PillEntity pillEntity){
        pillEntity.setState(State);
        PillEntity updated = pillRepo.save(pillEntity);
        return updated;
    }

    @DeleteMapping("/pill/{Id}")
    public void deleteBook(@PathVariable("Id") String Id) {
        pillRepo.deleteById(Id);
    }

}

