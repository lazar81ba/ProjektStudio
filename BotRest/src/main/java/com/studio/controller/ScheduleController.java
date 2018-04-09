package com.studio.controller;

import com.studio.model.Schedule;
import com.studio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(path = "/getStudentSchedule", method = RequestMethod.GET)
    @ResponseBody
    public Schedule getStudentSchedule(@RequestParam(value="index", required = true) String index) {
        return scheduleService.getScheduleForStudent(index);
    }

    @RequestMapping(path = "/getStudentScheduleForDay", method = RequestMethod.GET)
    @ResponseBody
    public Schedule getStudentScheduleForDay(@RequestParam(value="index", required = true) String index,
                                        @RequestParam(value="date", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date date) {

        System.out.println(date);

        return scheduleService.getScheduleForStudentWithDay(index,date);
    }
}
