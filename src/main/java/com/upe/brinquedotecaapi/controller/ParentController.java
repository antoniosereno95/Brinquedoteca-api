package com.upe.brinquedotecaapi.controller;





import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.model.dtos.ParentRegistrationDTO;
import com.upe.brinquedotecaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/parent")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerParent(@RequestBody ParentRegistrationDTO registrationDTO) {
            return ResponseEntity.ok(userService.registerParent(registrationDTO));
        }

    @PostMapping("/login/parent")
    public ResponseEntity<?> ParentLogin(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.parentLogin(loginDTO));
    }
}
