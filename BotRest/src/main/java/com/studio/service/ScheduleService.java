package com.studio.service;

import com.studio.model.Schedule;
import com.studio.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule getScheduleForStudent(String index){
        return scheduleRepository.getScheduleByIndex(index);
    }

    public Schedule getScheduleForStudentWithDay(String index, Date date) {
        return scheduleRepository.getScheduleByIndexAndDay(index, new Timestamp(date.getTime()));
    }
}
