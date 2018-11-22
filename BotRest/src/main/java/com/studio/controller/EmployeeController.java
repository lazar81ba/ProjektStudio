package com.studio.controller;

import com.studio.model.Consultation;
import com.studio.model.Employee;
import com.studio.model.Subject;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(path = "/employees/{university_nick}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable(value = "university_nick", required = true) String university_nick) {
        return employeeService.getEmployeeWithUniversityNick(university_nick);
    }

    @RequestMapping(path = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Employee> getEmployees(@RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "surname", required = false) String surname) {
        List<Employee> response = new LinkedList<>();
        if(name != null && surname != null)
            response = employeeService.getEmployeesWithNameAndSurname(name, surname);
        return response;
    }
}
