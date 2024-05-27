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
public class Child extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observations;
    private String description;

    public Child(Long id, Person info, String observations, String description) {
        super();
        this.id = id;
        this.observations = observations;
        this.description = description;
    }

    public Child() {
    }
}
