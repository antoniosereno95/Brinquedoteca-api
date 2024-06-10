package com.upe.brinquedotecaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "parents")
@Getter
@Setter
public class Parent extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LinkToInstitucion linkToInstitucion;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;

    @OneToOne
    private Address address;
   }