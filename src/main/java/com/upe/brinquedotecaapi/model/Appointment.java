package com.upe.brinquedotecaapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "appointments")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime arrival;

    private LocalDateTime retrival;

    @ManyToOne
    private Child child;

    @ManyToOne
    private Parent parent;

}
