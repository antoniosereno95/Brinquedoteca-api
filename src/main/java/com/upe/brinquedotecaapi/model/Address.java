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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String street; //rua
    private String district; //bairro
    private String city;
    private String state; //estado
    private int number;
    private String supplement; //complemento do endereço

    public Address(String cep, String street, String district, String city, String state, int number, String supplement) {
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.number = number;
        this.supplement = supplement;
    }

    public Address() {

    }
}
