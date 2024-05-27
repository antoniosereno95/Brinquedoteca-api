package com.upe.brinquedotecaapi.repository;

import com.upe.brinquedotecaapi.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Childrepository
        extends JpaRepository<Child, Long> {
}
