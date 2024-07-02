package com.upe.brinquedotecaapi.service;

import com.upe.brinquedotecaapi.controller.responses.AuthenticationResponse;
import com.upe.brinquedotecaapi.model.Brinquedista;
import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.model.Person;
import com.upe.brinquedotecaapi.model.dtos.BrinquedistaRegistrationDTO;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.model.dtos.ParentRegistrationDTO;
import com.upe.brinquedotecaapi.repository.BrinquedistaRepository;
import com.upe.brinquedotecaapi.repository.ParentRepository;
import com.upe.brinquedotecaapi.utils.exceptions.ConflictException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final ParentRepository parentRepository;
    private final BrinquedistaRepository brinquedistaRepository;
    private final BrinquedistaService brinquedistaService;
    private final ParentService parentService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Transactional
    public AuthenticationResponse registerParent(ParentRegistrationDTO parentRegistrationDTO) {
        if (parentRepository.findByEmail(parentRegistrationDTO.getEmail()).isPresent()) {
            throw new ConflictException("Usuário já existe");
        }

        Parent parent = parentService.createParent(parentRegistrationDTO);
        String jwtToken = jwtService.generateToken(parent);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    @Transactional
    public AuthenticationResponse registerBrinquesta(BrinquedistaRegistrationDTO brinquedistaRegistrationDTO) {
        if (brinquedistaRepository.findByEmail(brinquedistaRegistrationDTO.getEmail()).isPresent()) {
            throw new ConflictException("Usuário já existe");
        }
        Brinquedista brinquedista = brinquedistaService.createBrinquedista(brinquedistaRegistrationDTO);
        String jwtToken = jwtService.generateToken(brinquedista);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(LoginDTO loginDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                    loginDTO.getEmail(),
                    loginDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String jwtToken = jwtService.generateToken((Person) auth.getPrincipal());

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();

    }
}