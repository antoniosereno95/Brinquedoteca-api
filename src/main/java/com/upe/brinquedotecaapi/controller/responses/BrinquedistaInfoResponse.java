package com.upe.brinquedotecaapi.controller.responses;

import com.upe.brinquedotecaapi.model.*;
import lombok.Getter;


@Getter
public class BrinquedistaInfoResponse {
    private final String name;
    private final String lastName;
    private final Course course;
    private final String phone;
    private final Address address;

    public BrinquedistaInfoResponse(Brinquedista brinquedista) {
        this.name = brinquedista.getName();
        this.lastName = brinquedista.getLastName();
        this.course = brinquedista.getCourse();
        this.phone = brinquedista.getPhone();
        this.address = brinquedista.getAddress();
    }
}
