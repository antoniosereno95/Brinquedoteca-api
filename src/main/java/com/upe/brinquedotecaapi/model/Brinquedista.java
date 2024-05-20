package com.upe.brinquedotecaapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brinquedista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private Person info;
    private Course course;


    public Brinquedista(int id, Person info, Course course) {
        this.id = id;
        this.info = info;
        this.course = course;
    }

    public Brinquedista() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getInfo() {
        return info;
    }

    public void setInfo(Person info) {
        this.info = info;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
