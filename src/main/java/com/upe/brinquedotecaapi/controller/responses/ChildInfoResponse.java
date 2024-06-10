package com.upe.brinquedotecaapi.controller.responses;

import com.upe.brinquedotecaapi.model.Child;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ChildInfoResponse {
    private final String name;
    private final LocalDateTime birthday;
    private final String observations;
    private final String description;

    public ChildInfoResponse(Child child) {
        this.name = child.getName();
        this.birthday = child.getBirthday();
        this.observations = child.getObservations();
        this.description = child.getDescription();

    }
 }
