package com.studio.controller;

import com.studio.model.Consultation;
import com.studio.model.Room;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsultationController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/employees/{university_nick}/consultation", method = RequestMethod.GET)
    @ResponseBody
    public Consultation getConsultation(@PathVariable(value = "university_nick", required = true) String university_nick) {
        return employeeService.getEmployeeConsultation(university_nick);
    }

    @RequestMapping(path = "/employees/{university_nick}/consultation/room", method = RequestMethod.GET)
    @ResponseBody
    public Room getConsultationRoom(@PathVariable(value = "university_nick", required = true) String university_nick) {
        return employeeService.getEmployeeConsultation(university_nick).getRoom();
    }
}
