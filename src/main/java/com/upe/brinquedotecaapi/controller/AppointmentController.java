package com.upe.brinquedotecaapi.controller;

import com.upe.brinquedotecaapi.controller.responses.AppointmentResponse;
import com.upe.brinquedotecaapi.model.Person;
import com.upe.brinquedotecaapi.model.dtos.AppointmentDTO;
import com.upe.brinquedotecaapi.model.dtos.AppointmentWeeklyListingDTO;
import com.upe.brinquedotecaapi.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(summary = "Criar agendamento")
    @PostMapping("/appointment/agendar")
    public ResponseEntity<AppointmentResponse> createAppointment(
            @AuthenticationPrincipal Person person,
            @RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(new AppointmentResponse(appointmentService.createAppointment(appointmentDTO, person)));
    }

    @Operation(summary = "Lista agendamentos da semana")
    @GetMapping("/appointment/listar-semana")
    public ResponseEntity<Map<LocalDate, List<AppointmentWeeklyListingDTO>>> listWeeksAppointments() {
        return ResponseEntity.ok(appointmentService.listWeeksAppointments());
    }

    @Operation(summary = "Lista agendamentos de um responsável")
    @GetMapping("/parent/list")
    public ResponseEntity<Stream<AppointmentResponse>> listParentAppointments(
            @AuthenticationPrincipal Person person) {
        return ResponseEntity.ok(appointmentService
                        .listParentsAppoitments(person.getEmail())
                        .stream()
                        .map(AppointmentResponse::new));
    }
}