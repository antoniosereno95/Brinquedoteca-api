package com.upe.brinquedotecaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity(name="children")
@Getter
@Setter
public class Child extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parent parent;

    private String observations;

    private String description;

    @OneToOne
    private Address address;
}
