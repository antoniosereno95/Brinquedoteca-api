package com.upe.brinquedotecaapi.model.dtos;

import com.upe.brinquedotecaapi.model.LinkToInstitucion;
import lombok.*;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParentRegistrationDTO extends RegistrationDTO {
    private LinkToInstitucion linkToInstitucion;

}
