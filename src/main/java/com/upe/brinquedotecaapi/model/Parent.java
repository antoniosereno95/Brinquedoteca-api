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
public class Parent extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LinkToInstitucion linkToInstitucion;
    private Child children[];
    private String senha;

    public Parent(Long id, Person info, LinkToInstitucion linkToInstitucion, Child[] children ,String senha) {
        super();
        this.id = id;
        this.linkToInstitucion = linkToInstitucion;
        this.children = children;
        this.senha = senha;
    }

    public Parent() {

    }

   }
