package com.studio.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "consultation", schema = "public")
public class Consultation {
    @Id
    public long id;
    @Column(name = "data_start")
    Timestamp  dateStart;
    @Column(name = "data_end")
    Timestamp  dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_employee",nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_room",nullable = false)
    private Room room;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
