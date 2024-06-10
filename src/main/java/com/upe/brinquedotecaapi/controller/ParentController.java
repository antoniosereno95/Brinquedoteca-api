package com.upe.brinquedotecaapi.controller;





import com.upe.brinquedotecaapi.controller.responses.ParentRegistrationResponse;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.model.dtos.ParentRegistrationDTO;
import com.upe.brinquedotecaapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/parent")
@RequiredArgsConstructor
public class  ParentController {

    private final UserService userService;


    @Operation(summary = "Registrar como pai ou responsável")
    @PostMapping("/register")
    public ResponseEntity<?> registerParent(@RequestBody ParentRegistrationDTO registrationDTO) {
            return ResponseEntity.ok(new ParentRegistrationResponse(userService.registerParent(registrationDTO)));
        }

    @Operation(summary = "Fazer login como pai ou responsável")
    @PostMapping("/login")
    public ResponseEntity<?> parentLogin(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.parentLogin(loginDTO));
    }
}
