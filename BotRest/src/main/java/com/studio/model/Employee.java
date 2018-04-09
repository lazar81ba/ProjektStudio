package com.studio.model;

import java.sql.Timestamp;
import java.util.Date;

public class Employee {
    private Long id;
    private String name;
    private String surname;
    private Date birthDate;
    private Timestamp startConsultationTime;
    private Timestamp endConsultationTime;
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getStartConsultationTime() {
        return startConsultationTime;
    }

    public void setStartConsultationTime(Timestamp startConsultationTime) {
        this.startConsultationTime = startConsultationTime;
    }

    public Timestamp getEndConsultationTime() {
        return endConsultationTime;
    }

    public void setEndConsultationTime(Timestamp endConsultationTime) {
        this.endConsultationTime = endConsultationTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
