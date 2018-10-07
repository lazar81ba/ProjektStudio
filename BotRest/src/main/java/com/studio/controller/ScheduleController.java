package com.studio.controller;

import com.studio.model.Employee;
import com.studio.model.Plan;
import com.studio.model.Subject;
import com.studio.repository.EmployeeDAO;
import com.studio.repository.SubjectDAO;
import com.studio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(path = "/students/{index}/schedule", method = RequestMethod.GET)
    @ResponseBody
    public Plan getStudentSchedule(@PathVariable(value="index", required = true) String index) {
        return scheduleService.getPlanForStudent(index);
    }

    @RequestMapping(path = "/students/{index}/schedule/day", method = RequestMethod.GET)
    @ResponseBody
    public Plan getStudentScheduleForDay(@PathVariable(value="index", required = true) String index,
                                         @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {

        return scheduleService.getPlanForStudentByDay(index,date);
    }

    @RequestMapping(path = "/students/{index}/schedule/week", method = RequestMethod.GET)
    @ResponseBody
    public Plan getStudentScheduleForWeek(@PathVariable(value="index", required = true) String index,
                                         @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {

        return scheduleService.getPlanForStudentByWeek(index,date);
    }

    @RequestMapping(path = "/employees/{universityNick}/schedule", method = RequestMethod.GET)
    @ResponseBody
    public Plan getEmployeeSchedule(@PathVariable(value="universityNick", required = true) String universityNick) {
        return scheduleService.getPlanForEmployee(universityNick);
    }

    @RequestMapping(path = "/employees/{universityNick}/schedule/day", method = RequestMethod.GET)
    @ResponseBody
    public Plan getEmployeeScheduleForDay(@PathVariable(value="universityNick", required = true) String universityNick,
                                         @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {

        return scheduleService.getPlanForEmployeeByDay(universityNick,date);
    }

    @RequestMapping(path = "/employees/{universityNick}/schedule/week", method = RequestMethod.GET)
    @ResponseBody
    public Plan getEmployeeScheduleForWeek(@PathVariable(value="universityNick", required = true) String universityNick,
                                          @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {

        return scheduleService.getPlanForEmployeeByWeek(universityNick,date);
    }

}
