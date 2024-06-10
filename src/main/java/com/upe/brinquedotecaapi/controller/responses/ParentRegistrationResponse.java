package com.upe.brinquedotecaapi.controller.responses;

import com.upe.brinquedotecaapi.model.LinkToInstitucion;
import com.upe.brinquedotecaapi.model.Parent;
import lombok.Getter;

@Getter
public class ParentRegistrationResponse {
    private final String name;
    private final String lastName;
    private final String email;
    private final String phone;
    private final LinkToInstitucion linkToInstitucion;
    
    public ParentRegistrationResponse(Parent parent) {
        this.name = parent.getName();
        this.lastName = parent.getLastName();
        this.email = parent.getEmail();
        this.phone = parent.getPhone();
        this.linkToInstitucion = parent.getLinkToInstitucion();
    }
}
