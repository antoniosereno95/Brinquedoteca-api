package com.upe.brinquedotecaapi.controller;





import com.upe.brinquedotecaapi.controller.responses.AuthenticationResponse;
import com.upe.brinquedotecaapi.controller.responses.ParentInfoResponse;
import com.upe.brinquedotecaapi.model.Person;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.model.dtos.ParentRegistrationDTO;
import com.upe.brinquedotecaapi.service.AuthenticationService;
import com.upe.brinquedotecaapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/parent")
@RequiredArgsConstructor
public class  ParentController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Operation(summary = "Registrar como pai ou responsável")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerParent(@RequestBody ParentRegistrationDTO registrationDTO) {
            return ResponseEntity.ok(authenticationService.registerParent(registrationDTO));
        }

    @Operation(summary = "Fazer login como pai ou responsável")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> parentLogin(@RequestBody LoginDTO loginDTO) {

        return ResponseEntity.ok(authenticationService.authenticate(loginDTO));
    }

    @Operation(summary = "Solicitar informações do responsável")
    @GetMapping
    public ResponseEntity<ParentInfoResponse> getParentInfo(@AuthenticationPrincipal Person person) {
        return ResponseEntity.ok(new ParentInfoResponse(userService.findParentByEmail(person.getEmail())));
    }

    //@Operation(summary = "Atualiza os dados do responsável")
    //@PutMapping
    //public ResponseEntity<AuthenticationResponse> updateParent(@RequestBody ParentRegistrationDTO registrationDTO) {
        //return ResponseEntity.ok(authenticationService.)
    //}
}