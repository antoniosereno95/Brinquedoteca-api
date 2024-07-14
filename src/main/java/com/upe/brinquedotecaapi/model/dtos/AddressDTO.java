package com.upe.brinquedotecaapi.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class AddressDTO {

    private String cep;

    private String street;

    private String district;

    private String city;

    private String state;

    private int number;

    private String supplement;
}
