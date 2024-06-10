package com.upe.brinquedotecaapi.model.dtos;

import lombok.Data;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@Data
public class AppointmentWeeklyListingDTO {
    private LocalDateTime arrival;
    private LocalDateTime retrival;
    private String parentName;
    private String childName;
    private String weekDay;
}
