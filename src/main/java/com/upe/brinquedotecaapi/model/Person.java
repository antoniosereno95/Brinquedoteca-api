package com.upe.brinquedotecaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private String lastName;
    private LocalDateTime birthday;
    private Address address;

    public Person(String cpf, String name, String lastName, LocalDateTime preco, Address address) {
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
        this.birthday = preco;
        this.address = address;
    }

    public Person() {

    }

}
