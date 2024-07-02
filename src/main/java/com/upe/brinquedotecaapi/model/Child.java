package com.upe.brinquedotecaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity(name="children")
@Getter
@Setter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;
    @ManyToOne
    private Parent parent;

    @Column(unique = true)
    private String cpf;

    private String observations;

    private String description;

    private LocalDateTime birthday;

    @OneToMany(mappedBy = "child")
    private List<Appointment> appointment;

    @OneToOne
    private Address address;
}
