package com.upe.brinquedotecaapi.controller;


import com.upe.brinquedotecaapi.model.dtos.BrinquedistaRegistrationDTO;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brinquedista")
@RequiredArgsConstructor
public class BrinquedistaController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerBrinquedista(@RequestBody BrinquedistaRegistrationDTO registrationDTO) {
        return ResponseEntity.ok(userService.brinquedistaRegister(registrationDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginBrinquedista(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.brinquedistaLogin(loginDTO));
    }
}
