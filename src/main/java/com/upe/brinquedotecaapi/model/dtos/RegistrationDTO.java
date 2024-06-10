package com.upe.brinquedotecaapi.model.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class RegistrationDTO {

    @CPF(message = "CPF inválido")
    @NotBlank
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank
    @Pattern(regexp = "(\\d{2}) \\d{5}-\\d{4}", message = "Phone number format is incorrect")
    private String phone;

    @NotBlank
    @Pattern(regexp = ".*[0-9].*", message="falta um digito")
    @Pattern(regexp = ".*[a-z].*", message="falta uma letra minuscula")
    @Pattern(regexp = ".*[A-Z].*", message="falta uma lestra maiuscula")
    @Pattern(regexp = ".*[!@#&()–[{}]:;',?/*~$^+=<>].*", message="falta um caracter especial")
    @Pattern(regexp = "^.{8,20}$", message="o tamanho da senha deve ser entre 8 e 20 caracteres")
    private String password;

    @NotBlank
    private AddressDTO address;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime birthday;



}
