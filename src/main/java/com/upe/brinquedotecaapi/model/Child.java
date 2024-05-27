package com.upe.brinquedotecaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Person Info;
    private String observations;
    private String description;

    public Child(Long id, Person info, String observations, String description) {
        this.id = id;
        this.Info = info;
        this.observations = observations;
        this.description = description;
    }

    public Child() {
    }
}
