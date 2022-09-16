package com.example.DrServer.Service;

import com.example.DrServer.Entity.PillEntity;
import com.example.DrServer.Repo.PillRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PillService {
    private final PillRepo pillRepo;

    public List<PillEntity> selectPills() {
        return pillRepo.findAll();
    }
    public PillEntity getPills(String Id) {
        return pillRepo.findById(Id).orElseThrow(IllegalArgumentException::new);
    }
    public PillEntity savePills(PillEntity pillEntity) {
        return pillRepo.save(pillEntity);
    }
    public void deletePills(String Id) {
        pillRepo.deleteById(Id);
    }
    @Transactional
    public PillEntity updatePills(String Id, PillEntity pillEntity) {
        PillEntity pillData = pillRepo.findById(Id).orElseThrow(IllegalArgumentException::new);
        pillData.update(pillEntity.getId(), pillEntity.getState());
        return pillData;
    }
}
