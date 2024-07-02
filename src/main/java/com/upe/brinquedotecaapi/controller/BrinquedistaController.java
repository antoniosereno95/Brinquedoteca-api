package com.upe.brinquedotecaapi.controller;


import com.upe.brinquedotecaapi.controller.responses.BrinquedistaInfoResponse;
import com.upe.brinquedotecaapi.model.Person;
import com.upe.brinquedotecaapi.model.dtos.BrinquedistaRegistrationDTO;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.service.AuthenticationService;
import com.upe.brinquedotecaapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/brinquedista")
@RequiredArgsConstructor
public class BrinquedistaController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Operation(summary = "Registrar brinquedista")
    @PostMapping("/register")
    public ResponseEntity<?> registerBrinquedista(@RequestBody BrinquedistaRegistrationDTO registrationDTO) {
        return ResponseEntity.ok(authenticationService.registerBrinquesta(registrationDTO));
    }

    @Operation(summary = "Fazer login como brinquedista")
    @PostMapping("/login")
    public ResponseEntity<?> loginBrinquedista(@RequestBody LoginDTO loginDTO) {

        return ResponseEntity.ok(authenticationService.authenticate(loginDTO));
    }

    @Operation(summary = "Resgatar as informações do brinquedista")
    @GetMapping("/info")
    public ResponseEntity<?> getBrinquedistaInfo(@AuthenticationPrincipal Person person) {
        return ResponseEntity.ok(new BrinquedistaInfoResponse(userService.findBrinquedistaByEmail(person.getEmail())));
    }
}