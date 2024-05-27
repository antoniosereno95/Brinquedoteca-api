package com.upe.brinquedotecaapi.service;

import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Optional<Parent> login(String email, String senha) {
        Optional<Parent> parentOpt = parentRepository.findByEmail(email);
        if (parentOpt.isPresent()) {
            Parent parent = parentOpt.get();
            if (parent.getSenha().equals(senha)) {
                return Optional.of(parent);
            }
        }
        return Optional.empty();
    }
}
