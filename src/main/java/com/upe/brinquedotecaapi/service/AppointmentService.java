package com.upe.brinquedotecaapi.service;


import com.upe.brinquedotecaapi.controller.responses.AppointmentResponse;
import com.upe.brinquedotecaapi.model.Appointment;
import com.upe.brinquedotecaapi.model.Child;
import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.model.dtos.AppointmentDTO;
import com.upe.brinquedotecaapi.model.dtos.AppointmentWeeklyListingDTO;
import com.upe.brinquedotecaapi.repository.AppointmentRepository;
import com.upe.brinquedotecaapi.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final UserService userService;

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        Parent parent = userService.findParentByEmail(appointmentDTO.getParentEmail());
        Child child = parent
                .getChildren()
                .stream()
                .filter(children -> children.getId().equals(appointmentDTO.getChildId()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Criança não encontrada"));

        appointment.setChild(child);
        appointment.setArrival(appointmentDTO.getArrival());
        appointment.setRetrival(appointmentDTO.getRetrival());
        appointment.setParent(parent);

        return appointmentRepository.save(appointment);
    }

    public  Map<LocalDate, List<AppointmentWeeklyListingDTO>> listWeeksAppointments() {
        LocalDate now = LocalDate.now();
        LocalDate startOfWeek = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        LocalDateTime startOfWeekDateTime = LocalDateTime.of(startOfWeek, LocalTime.MIN);
        LocalDateTime endOfWeekDateTime = LocalDateTime.of(endOfWeek, LocalTime.MAX);

        List<Appointment> appointments =  appointmentRepository.findAppointmentsByRetrivalBetween(startOfWeekDateTime, endOfWeekDateTime);
        return appointments.stream()
                .map(appointment -> {
                    AppointmentWeeklyListingDTO dto = new AppointmentWeeklyListingDTO();
                    dto.setArrival(appointment.getArrival());
                    dto.setRetrival(appointment.getRetrival());
                    dto.setParentName(appointment.getParent().getName());
                    dto.setChildName(appointment.getChild().getName());
                    dto.setWeekDay(appointment.getArrival().getDayOfWeek().name());
                    return dto;
                })
                .collect(Collectors.groupingBy(dto -> dto.getArrival().toLocalDate()));
    }
}
