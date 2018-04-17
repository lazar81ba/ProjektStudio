package com.studio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "schedule",schema = "public")
public class Schedule {

    @Id
    private long id;

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", group=" + group +
                ", subject=" + subject +
                ", room=" + room +
                '}';
    }

    @Column(name = "data_start")
    Timestamp  dateStart;
    @Column(name = "data_end")
    Timestamp  dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_group",nullable = true)
    private Group group;
    @ManyToOne
    @JoinColumn(name = "id_subject",nullable = true)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "id_room",nullable = true)
    private Room room;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
}
