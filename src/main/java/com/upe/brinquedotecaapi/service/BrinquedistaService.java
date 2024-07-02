package com.upe.brinquedotecaapi.service;

import com.upe.brinquedotecaapi.model.Address;
import com.upe.brinquedotecaapi.model.Brinquedista;
import com.upe.brinquedotecaapi.model.RoleEnum;
import com.upe.brinquedotecaapi.model.dtos.BrinquedistaRegistrationDTO;
import com.upe.brinquedotecaapi.repository.AddressRepository;
import com.upe.brinquedotecaapi.repository.BrinquedistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrinquedistaService {

    private final BrinquedistaRepository brinquedistaRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;

    public Brinquedista createBrinquedista(BrinquedistaRegistrationDTO brinquedistaRegistrationDTO) {
        Brinquedista brinquedista = new Brinquedista();
        Address address = new Address();
        BeanUtils.copyProperties(brinquedistaRegistrationDTO, brinquedista, "password");
        BeanUtils.copyProperties(brinquedistaRegistrationDTO.getAddress(), address);
        brinquedista.setPassword(passwordEncoder.encode(brinquedistaRegistrationDTO.getPassword()));
        brinquedista.setRole(RoleEnum.BRINQUEDISTA);
        addressRepository.save(address);
        return brinquedistaRepository.save(brinquedista);

    }
}
