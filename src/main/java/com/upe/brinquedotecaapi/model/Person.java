package com.upe.brinquedotecaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private String lastName;
    private DateTimeFormat birthday; //Esse aqui ta com a tipagem errada
    private Address address;

    public Person(Long cpf, String name, String lastName, DateTimeFormat preco, Address address) {
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
        this.birthday = preco;
        this.address = address;
    }

    public Person() {

    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTimeFormat getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTimeFormat birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
