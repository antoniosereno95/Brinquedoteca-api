package com.upe.brinquedotecaapi.controller.responses;

import com.upe.brinquedotecaapi.model.Child;
import lombok.Getter;

import java.util.List;

@Getter
public class ListChildrenResponse {
    private final List<ChildRegistrationResponse> childrenList;

    public ListChildrenResponse(List<Child> children) {
        this.childrenList = children.stream().map(ChildRegistrationResponse::new).toList();
    }
}
