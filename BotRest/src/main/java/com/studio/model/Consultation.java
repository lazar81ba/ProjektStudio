package com.studio.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Consultation {

    private Time startConsultationTime;
    private Time endConsultationTime;
    private String consultationDay;
    private Room room;


    public Consultation(){};

    public Consultation(Time startConsultationTime, Time endConsultationTime, String consultationDay, Room room) {
        this.startConsultationTime = startConsultationTime;
        this.endConsultationTime = endConsultationTime;
        this.consultationDay = consultationDay;
        this.room = room;
    }

    public String getConsultationDay() {
        return consultationDay;
    }

    public void setConsultationDay(String consultationDay) {
        this.consultationDay = consultationDay;
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
