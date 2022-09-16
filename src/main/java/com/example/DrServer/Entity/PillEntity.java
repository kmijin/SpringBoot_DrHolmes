package com.example.DrServer.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pill_state")
@Data
@AllArgsConstructor
public class PillEntity {

    public PillEntity(){}

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(nullable = false)
    private String State;

    public void update(String Id, String State) {
        this.Id = Id;
        this.State = State;
    }
}
