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
public class Brinquedista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Person info;
    private Course course;


    public Brinquedista(Long id, Person info, Course course) {
        this.id = id;
        this.info = info;
        this.course = course;
    }

    public Brinquedista() {

    }
}
