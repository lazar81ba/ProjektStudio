package com.studio.service;

import com.studio.model.Schedule;
import com.studio.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule getScheduleForStudent(String index){
        return scheduleRepository.getSchedule(index);
    }
}
