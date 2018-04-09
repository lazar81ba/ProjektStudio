package com.studio.repository;

import com.studio.model.Schedule;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ScheduleRepository extends com.studio.repository.Repository{
    public Schedule getSchedule(String index) {
        Schedule schedule = new Schedule();
        return schedule;
    }
}
