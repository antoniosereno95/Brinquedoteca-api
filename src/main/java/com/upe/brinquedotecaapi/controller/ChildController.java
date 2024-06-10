package com.upe.brinquedotecaapi.controller;

import com.upe.brinquedotecaapi.controller.responses.ChildRegistrationResponse;
import com.upe.brinquedotecaapi.controller.responses.ListChildrenResponse;
import com.upe.brinquedotecaapi.model.dtos.ChildRegistrationDTO;
import com.upe.brinquedotecaapi.service.ChildService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/child")
public class ChildController {
    private final ChildService childService;

    @Operation(summary = "Adiciona criança ao perfil do responsável")
    @PostMapping
    public ResponseEntity<?>  addChildToParent(@RequestBody ChildRegistrationDTO registrationDTO) {
        return ResponseEntity.ok(new ChildRegistrationResponse(childService.addChildToParent(registrationDTO)));
    }

    @Operation(summary = "Retorna todas as crianças de um responsável")
    @GetMapping
    public ResponseEntity<?> listChildren(@RequestParam String parentEmail) {
        return ResponseEntity.ok(new ListChildrenResponse(childService.listChildren(parentEmail)));
    }
}
