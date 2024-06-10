package com.upe.brinquedotecaapi.service;


import com.upe.brinquedotecaapi.model.Appointment;
import com.upe.brinquedotecaapi.model.Child;
import com.upe.brinquedotecaapi.model.Parent;
import com.upe.brinquedotecaapi.model.dtos.ChildRegistrationDTO;
import com.upe.brinquedotecaapi.repository.Childrepository;
import com.upe.brinquedotecaapi.repository.ParentRepository;
import com.upe.brinquedotecaapi.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final Childrepository childrepository;
    private final ParentRepository parentRepository;
    private final UserService userService;

    public Child addChildToParent(ChildRegistrationDTO childRegistrationDTO) {
        Parent parent = userService.findParentByEmail(childRegistrationDTO.getParentEmail());
        Child child = new Child();
        List<Appointment> appointmentList = new ArrayList<>();
        child.setAppointment(appointmentList);
        BeanUtils.copyProperties(childRegistrationDTO, child);
        child.setParent(parent);
        List<Child> parentChilds  = parent.getChildren();
        parentChilds.add(child);
        parentRepository.save(parent);

        return childrepository.save(child);
    }

    public List<Child> listChildren(String parentEmail) {
        Parent parent = parentRepository
                .findByEmail(parentEmail)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar pai ou responsável"));
        return parent.getChildren();
    }

    public Child getChild(String parentEmail, Long childId) {
        List<Child> children = listChildren(parentEmail);
        return children
                .stream()
                .filter(c -> c.getId().equals(childId))
                .findFirst().orElseThrow(() -> new NotFoundException("Child not found"));


    }
}