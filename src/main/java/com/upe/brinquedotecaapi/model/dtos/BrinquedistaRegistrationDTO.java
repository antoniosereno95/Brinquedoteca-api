package com.upe.brinquedotecaapi.model.dtos;


import com.upe.brinquedotecaapi.model.Course;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Data
public class BrinquedistaRegistrationDTO extends RegistrationDTO {
    private Course course;
}
