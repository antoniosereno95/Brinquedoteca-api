package com.upe.brinquedotecaapi.service;

import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.model.dtos.ParentDTO;
import com.upe.brinquedotecaapi.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;


    public Parent register(ParentDTO parentDTO) {

    }

    public Optional<Parent> login(String email, String senha) {
        Optional<Parent> parentOpt = parentRepository.findByEmail(email);
        if (parentOpt.isPresent()) {
            Parent parent = parentOpt.get();
            if (parent.getPassword().equals(senha)) {
                return Optional.of(parent);
            }
        }
        return Optional.empty();
    }
}