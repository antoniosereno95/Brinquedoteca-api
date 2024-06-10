package com.upe.brinquedotecaapi.controller.responses;

import com.upe.brinquedotecaapi.model.Child;
import lombok.Getter;

@Getter
public class ChildRegistrationResponse {
    private final Long id;
    private final String name;
    private final String lastName;
    private final String observations;
    private final String description;

    public ChildRegistrationResponse(Child child) {
        this.id = child.getId();
        this.name = child.getName();
        this.lastName = child.getLastName();
        this.observations = child.getObservations();
        this.description = child.getDescription();
    }
}
