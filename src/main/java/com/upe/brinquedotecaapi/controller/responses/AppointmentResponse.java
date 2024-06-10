package com.upe.brinquedotecaapi.controller.responses;


import com.upe.brinquedotecaapi.model.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponse {

    private final String parentName;
    private final String childName;
    private final LocalDateTime arrival;
    private final LocalDateTime retrival;

    public AppointmentResponse(Appointment appointment) {
        this.parentName = appointment.getParent().getName() + ' ' + appointment.getParent().getLastName();
        this.childName = appointment.getChild().getName() + ' ' +  appointment.getChild().getLastName();
        this.arrival = appointment.getArrival();
        this.retrival = appointment.getRetrival();
    }
}
