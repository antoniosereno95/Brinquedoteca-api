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
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Person info;
    private LinkToInstitucion linkToInstitucion;
    private Child children[];

    public Parent(Long id, Person info, LinkToInstitucion linkToInstitucion, Child[] children) {
        this.id = id;
        this.info = info;
        this.linkToInstitucion = linkToInstitucion;
        this.children = children;
    }

    public Parent() {

    }

   }
