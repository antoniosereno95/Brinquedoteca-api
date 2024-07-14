package com.upe.brinquedotecaapi.controller;

import com.upe.brinquedotecaapi.controller.responses.ChildInfoResponse;
import com.upe.brinquedotecaapi.controller.responses.ChildRegistrationResponse;
import com.upe.brinquedotecaapi.controller.responses.ListChildrenResponse;
import com.upe.brinquedotecaapi.model.Person;
import com.upe.brinquedotecaapi.model.dtos.ChildRegistrationDTO;
import com.upe.brinquedotecaapi.service.ChildService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/child")
public class ChildController {
    private final ChildService childService;

    @Operation(summary = "Adiciona criança ao perfil do responsável")
    @PostMapping
    public ResponseEntity<ChildRegistrationResponse>  addChildToParent(
            @AuthenticationPrincipal Person person,
            @RequestBody ChildRegistrationDTO registrationDTO) {
        return ResponseEntity.ok(new ChildRegistrationResponse(childService.addChildToParent(registrationDTO, person)));
    }

    @Operation(summary = "Retorna todas as crianças de um responsável")
    @GetMapping("/list")
    public ResponseEntity<ListChildrenResponse> listChildren(
            @AuthenticationPrincipal Person person) {
        return ResponseEntity.ok(new ListChildrenResponse(childService.listChildren(person.getEmail())));
    }

    @Operation(summary = "Retorna as informações da criança")
    @GetMapping
    public ResponseEntity<ChildInfoResponse> getChildInfo(@AuthenticationPrincipal Person person, @RequestParam Long childId) {
        return ResponseEntity.ok(new ChildInfoResponse(childService.getChild(person.getEmail(), childId)));
    }
 }
