package com.studio.controller;

import com.studio.model.Consultation;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsultationController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/getConsultationByName", method = RequestMethod.GET)
    @ResponseBody
    public Consultation getConsultationByName(@RequestParam(value = "name", required = true) String name,
                                    @RequestParam(value = "surname", required = true) String surname) {
        return employeeService.getEmployeeConsultation(name,surname);
    }
}
