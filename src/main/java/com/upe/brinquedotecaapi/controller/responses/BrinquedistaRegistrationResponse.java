package com.upe.brinquedotecaapi.controller.responses;

import com.upe.brinquedotecaapi.model.Brinquedista;
import com.upe.brinquedotecaapi.model.Course;
import lombok.Getter;

@Getter
public class BrinquedistaRegistrationResponse {
    private final String name;
    private final String lastName;
    private final String email;
    private final String phone;
    private final Course course;

    public BrinquedistaRegistrationResponse(Brinquedista registration) {
        this.name = registration.getName();
        this.lastName = registration.getLastName();
        this.email = registration.getEmail();
        this.phone = registration.getPhone();
        this.course = registration.getCourse();
    }
}
