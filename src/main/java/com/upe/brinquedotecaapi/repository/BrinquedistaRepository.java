package com.upe.brinquedotecaapi.repository;

import com.upe.brinquedotecaapi.model.Brinquedista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrinquedistaRepository extends JpaRepository<Brinquedista, Long> {

    Optional<Brinquedista> findByEmail(String email);
}
