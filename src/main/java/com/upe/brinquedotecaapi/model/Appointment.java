package com.upe.brinquedotecaapi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private Child child;
    private Parent parent;

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime dateTime, Child child, Parent parent) {
        this.id = id;
        this.dateTime = dateTime;
        this.child = child;
        this.parent = parent;
    }
}
