package com.studio.model;

import java.util.LinkedList;
import java.util.List;

public class Plan {

    List<Schedule> scheduleList = new LinkedList<Schedule>();

    public Plan(){};

    public Plan(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public void addSchedulePosition(Schedule position){
        scheduleList.add(position);
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

}
