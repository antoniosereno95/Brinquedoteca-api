package com.upe.brinquedotecaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String name;

    private String lastName;

    private String password;

    private LocalDateTime birthday;

    @Column(unique = true)
    private String email;

    private String phone;
}
