package com.upe.brinquedotecaapi.controller;

import com.upe.brinquedotecaapi.controller.responses.AppointmentResponse;
import com.upe.brinquedotecaapi.model.dtos.AppointmentDTO;
import com.upe.brinquedotecaapi.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(summary = "Criar agendamento")
    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(new AppointmentResponse(appointmentService.createAppointment(appointmentDTO)));
    }

    @Operation(summary = "Lista agendamentos da semana")
    @GetMapping
    public ResponseEntity<?> listWeeksAppointments() {
        return ResponseEntity.ok(appointmentService.listWeeksAppointments());
    }

    @Operation(summary = "Lista agendamentos de um responsável")
    @GetMapping("/parent/list")
    public ResponseEntity<?> listParentAppointments(@RequestParam String email) {
        return ResponseEntity.ok(appointmentService.listParentsAppoitments(email).stream().map(AppointmentResponse::new));
    }
}