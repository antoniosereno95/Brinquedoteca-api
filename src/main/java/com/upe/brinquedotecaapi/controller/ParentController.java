package com.upe.brinquedotecaapi.controller;

import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) { //esse recebimento do RequestBody vai ter que mudar pq depende do JSON que chega no frontend
        Optional<Parent> parentOpt = parentService.login(loginRequest.getEmail(), loginRequest.getSenha());
        if (parentOpt.isPresent()) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}

class LoginRequest {
    private String email;
    private String senha;

    // Getters e setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

