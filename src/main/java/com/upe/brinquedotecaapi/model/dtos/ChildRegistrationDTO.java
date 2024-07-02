package com.upe.brinquedotecaapi.model.dtos;


import lombok.*;

import java.time.LocalDateTime;

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
    private String observations;
    private String description;
    private LocalDateTime birthday;

}
