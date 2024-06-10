package com.upe.brinquedotecaapi.controller;


import com.upe.brinquedotecaapi.controller.responses.BrinquedistaInfoResponse;
import com.upe.brinquedotecaapi.model.dtos.BrinquedistaRegistrationDTO;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/brinquedista")
@RequiredArgsConstructor
public class BrinquedistaController {

    private final UserService userService;

    @Operation(summary = "Registrar brinquedista")
    @PostMapping("/register")
    public ResponseEntity<?> registerBrinquedista(@RequestBody BrinquedistaRegistrationDTO registrationDTO) {
        return ResponseEntity.ok(userService.brinquedistaRegister(registrationDTO));
    }

    @Operation(summary = "Fazer login como brinquedista")
    @PostMapping("/login")
    public ResponseEntity<?> loginBrinquedista(@RequestBody LoginDTO loginDTO) {
        userService.brinquedistaLogin(loginDTO);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Resgatar as informações do brinquedista")
    @GetMapping
    public ResponseEntity<?> getBrinquedistaInfo(@RequestParam String brinquedistaEmail) {
        return ResponseEntity.ok(new BrinquedistaInfoResponse(userService.findBrinquedistaByEmail(brinquedistaEmail)));
    }
}