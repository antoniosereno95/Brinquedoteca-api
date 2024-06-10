package com.upe.brinquedotecaapi.model.dtos;

import lombok.Data;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@Data
public class AppointmentDTO {
    private LocalDateTime arrival;
    private LocalDateTime retrival;
    private String parentEmail;
    private Long childId;
}
