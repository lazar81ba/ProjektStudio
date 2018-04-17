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
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private SubjectDAO subjectDAO;

    @RequestMapping(path = "/getStudentSchedule", method = RequestMethod.GET)
    @ResponseBody
    public Plan getStudentSchedule(@RequestParam(value="index", required = true) String index) {
        return scheduleService.getPlanForStudent(index);
    }

    @RequestMapping(path = "/getStudentScheduleForDay", method = RequestMethod.GET)
    @ResponseBody
    public Plan getStudentScheduleForDay(@RequestParam(value="index", required = true) String index,
                                         @RequestParam(value="date", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date date) {

        return scheduleService.getPlanForStudentByDay(index,date);
    }

    @RequestMapping(path = "/getStudentScheduleForWeek", method = RequestMethod.GET)
    @ResponseBody
    public Plan getStudentScheduleForWeek(@RequestParam(value="index", required = true) String index,
                                         @RequestParam(value="date", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date date) {

        return scheduleService.getPlanForStudentByWeek(index,date);
    }

    @RequestMapping(path = "/getEmployeeSchedule", method = RequestMethod.GET)
    @ResponseBody
    public Plan getEmployeeSchedule(@RequestParam(value="universityNick", required = true) String universityNick) {
        return scheduleService.getPlanForEmployee(universityNick);
    }

    @RequestMapping(path = "/getEmployeeScheduleForDay", method = RequestMethod.GET)
    @ResponseBody
    public Plan getEmployeeScheduleForDay(@RequestParam(value="universityNick", required = true) String universityNick,
                                         @RequestParam(value="date", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date date) {

        return scheduleService.getPlanForEmployeeByDay(universityNick,date);
    }

    @RequestMapping(path = "/getEmployeeScheduleForWeek", method = RequestMethod.GET)
    @ResponseBody
    public Plan getEmployeeScheduleForWeek(@RequestParam(value="universityNick", required = true) String universityNick,
                                          @RequestParam(value="date", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date date) {

        return scheduleService.getPlanForEmployeeByWeek(universityNick,date);
    }

}
