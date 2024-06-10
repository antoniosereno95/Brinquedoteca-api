package com.upe.brinquedotecaapi.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class LoginDTO {

    private String email;
    private String password;
}
