package com.upe.brinquedotecaapi.repository;

import com.upe.brinquedotecaapi.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository
        extends JpaRepository<Parent, Long> {
}
