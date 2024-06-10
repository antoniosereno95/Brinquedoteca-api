package com.upe.brinquedotecaapi.model.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ChildRegistrationDTO {

    private String cpf;
    private String name;
    private String lastName;
    private AddressDTO address;
    private String parentEmail;
    private String observations;
    private String description;

}
