package com.upe.brinquedotecaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Person info;
    private LinkToInstitucion linkToInstitucion;
    private Child children[];

    public Parent(Long id, Person info, LinkToInstitucion linkToInstitucion, Child[] children) {
        this.id = id;
        this.info = info;
        this.linkToInstitucion = linkToInstitucion;
        this.children = children;
    }

    public Parent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getInfo() {
        return info;
    }

    public void setInfo(Person info) {
        this.info = info;
    }

    public LinkToInstitucion getLinkToInstitucion() {
        return linkToInstitucion;
    }

    public void setLinkToInstitucion(LinkToInstitucion linkToInstitucion) {
        this.linkToInstitucion = linkToInstitucion;
    }

    public Child[] getChildren() {
        return children;
    }

    public void setChildren(Child[] children) {
        this.children = children;
    }
}
