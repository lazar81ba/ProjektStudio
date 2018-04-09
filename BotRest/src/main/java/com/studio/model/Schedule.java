package com.studio.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Schedule {

    List<SchedulePosition> schedulePositionList = new LinkedList<SchedulePosition>();

    public void addSchedulePosition(SchedulePosition position){
        schedulePositionList.add(position);
    }

    public List<SchedulePosition> getSchedulePositionList() {
        return schedulePositionList;
    }

    public void setSchedulePositionList(List<SchedulePosition> schedulePositionList) {
        this.schedulePositionList = schedulePositionList;
    }

}
