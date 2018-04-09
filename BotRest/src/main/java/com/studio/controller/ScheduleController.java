package com.studio.controller;

import com.studio.model.Schedule;
import com.studio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(path = "/getSchedule", method = RequestMethod.GET)
    @ResponseBody
    public Schedule getSchedule(@RequestParam(value="index", required = true) String index) {
        return scheduleService.getScheduleForStudent(index);
    }
}
