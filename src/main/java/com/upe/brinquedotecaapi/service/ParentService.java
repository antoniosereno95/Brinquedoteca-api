package com.upe.brinquedotecaapi.service;

import com.upe.brinquedotecaapi.model.Address;
import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.model.RoleEnum;
import com.upe.brinquedotecaapi.model.dtos.ParentRegistrationDTO;
import com.upe.brinquedotecaapi.repository.AddressRepository;
import com.upe.brinquedotecaapi.repository.ParentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Parent createParent(ParentRegistrationDTO parentRegistrationDTO) {
        Parent parent = new Parent();
        Address address = new Address();
        BeanUtils.copyProperties(parentRegistrationDTO.getAddress(), address);
        BeanUtils.copyProperties(parentRegistrationDTO, parent, "password");
        parent.setPassword(passwordEncoder.encode(parentRegistrationDTO.getPassword()));
        parent.setRole(RoleEnum.RESPONSAVEL);
        parent.setChildren(new ArrayList<>());
        parent.setAddress(address);
        addressRepository.save(address);

        return parentRepository.save(parent);
    }
}
