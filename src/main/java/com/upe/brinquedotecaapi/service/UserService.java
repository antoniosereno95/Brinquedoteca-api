package com.upe.brinquedotecaapi.service;

import com.upe.brinquedotecaapi.model.Address;
import com.upe.brinquedotecaapi.model.Brinquedista;
import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.model.dtos.BrinquedistaRegistrationDTO;
import com.upe.brinquedotecaapi.model.dtos.LoginDTO;
import com.upe.brinquedotecaapi.model.dtos.ParentRegistrationDTO;
import com.upe.brinquedotecaapi.repository.AddressRepository;
import com.upe.brinquedotecaapi.repository.BrinquedistaRepository;
import com.upe.brinquedotecaapi.repository.ParentRepository;
import com.upe.brinquedotecaapi.utils.exceptions.BadRequestException;
import com.upe.brinquedotecaapi.utils.exceptions.ConflictException;
import com.upe.brinquedotecaapi.utils.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ParentRepository parentRepository;
    private final BrinquedistaRepository brinquedistaRepository;
    private final AddressRepository addressRepository;

    public Parent registerParent(ParentRegistrationDTO registrationDTO) {
        if (parentRepository.findByEmail(registrationDTO.getEmail()).isPresent()) {
            throw new ConflictException("Usuário já existe");
        }
        Parent parent = new Parent();
        Address address = new Address();

        BeanUtils.copyProperties(registrationDTO.getAddress(), address);
        parent.setAddress(address);
        addressRepository.save(address);
        parent.setChildren(new ArrayList<>());


        BeanUtils.copyProperties(registrationDTO, parent);
        return parentRepository.save(parent);
    }

    public Parent parentLogin(LoginDTO loginDTO) {
        Optional<Parent> parent = parentRepository.findByEmail(loginDTO.getEmail());
        if (parent.isPresent() && loginDTO.getPassword().equals(parent.get().getPassword())) {
            return parent.get();
        } else {
            throw new BadRequestException("Senha ou usuário incorretos");
        }
    }

    @Transactional
    public Brinquedista brinquedistaRegister(BrinquedistaRegistrationDTO registrationDTO) {

        if (brinquedistaRepository.findBrinquedistaByEmail(registrationDTO.getEmail()).isPresent()) {
            throw new ConflictException("Usuário já existe");
        }

        Brinquedista brinquedista = new Brinquedista();
        Address address = new Address();

        BeanUtils.copyProperties(registrationDTO.getAddress(), address);
        brinquedista.setAddress(address);
        addressRepository.save(address);

        BeanUtils.copyProperties(registrationDTO, brinquedista);
        return brinquedistaRepository.save(brinquedista);
    }

    public Brinquedista brinquedistaLogin(LoginDTO loginDTO) {
        Brinquedista brinquedista = brinquedistaRepository
                .findBrinquedistaByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new NotFoundException("Ocorreu um erro ao realizar o login"));

        if (loginDTO.getPassword().equals(brinquedista.getPassword())) {
            return brinquedista;
        } else {
            throw new NotFoundException("Senha ou usuário incorretos");
        }
    }
}