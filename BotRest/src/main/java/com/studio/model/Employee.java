package com.studio.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee",schema = "public")
public class Employee {

    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "start_consultation_time")
    private Time startConsultationTime;
    @Column(name = "end_consultation_time")
    private Time endConsultationTime;
    @Column(name = "consultation_day")
    private String consultationDay;
    @Column(name="university_nick")
    private String universityNick;

    @ManyToOne
    @JoinColumn(name = "id_room",nullable = true)
    private Room room;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "assignation",
            joinColumns = { @JoinColumn(name = "id_employee") },
            inverseJoinColumns = { @JoinColumn(name = "id_subject") }
    )
    private Set<Subject> subjects = new HashSet<>();


    public String getConsultationDay() {
        return consultationDay;
    }

    public void setConsultationDay(String consultationDay) {
        this.consultationDay = consultationDay;
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

    public Time getStartConsultationTime() {
        return startConsultationTime;
    }

    public void setStartConsultationTime(Time startConsultationTime) {
        this.startConsultationTime = startConsultationTime;
    }

    public Time getEndConsultationTime() {
        return endConsultationTime;
    }

    public void setEndConsultationTime(Time endConsultationTime) {
        this.endConsultationTime = endConsultationTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
