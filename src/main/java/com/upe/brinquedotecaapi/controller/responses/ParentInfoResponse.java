package com.upe.brinquedotecaapi.controller.responses;


import com.upe.brinquedotecaapi.model.Address;
import com.upe.brinquedotecaapi.model.LinkToInstitucion;
import com.upe.brinquedotecaapi.model.Parent;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ParentInfoResponse {
    private final String name;
    private final String lastName;
    private final List<ChildRegistrationResponse> children;

    private final LinkToInstitucion linkToInstitucion;
    private final Address address;

    public ParentInfoResponse(Parent parent) {
        this.name = parent.getName();
        this.lastName = parent.getLastName();
        this.children = parent.getChildren().stream().map(ChildRegistrationResponse::new).collect(Collectors.toList());
        this.linkToInstitucion = parent.getLinkToInstitucion();
        this.address = parent.getAddress();

    }
}
