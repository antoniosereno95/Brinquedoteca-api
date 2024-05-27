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
    private String cpf;
    private String name;
    private String lastName;
    private LocalDateTime birthday;
    private String email;
    //Tive que comnetar os dois abaixo pra usar o @MappedSuperclass
    //private Address address;
    //private Role role;

    //Inicio -> Antiga Classe Address
    private String cep;
    private String street; //rua
    private String district; //bairro
    private String city;
    private String state; //estado
    private int number;
    private String supplement;
    //Fim -> Antiga Classe Address
    public Person() {

    }

    //construtor normal para Child
    public Person(Long id, String cpf, String name, String lastName, LocalDateTime birthday) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    //construtor completo para Parent

    public Person(Long id, String cpf, String name, String lastName,
                  LocalDateTime birthday, String email, String cep, String street,
                  String district, String city, String state, int number, String supplement) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number = number;
        this.supplement = supplement;
    }
}
