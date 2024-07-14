package com.upe.brinquedotecaapi.repository;


import com.upe.brinquedotecaapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAppointmentsByRetrivalBetween(LocalDateTime startDate, LocalDateTime endDate);
}
