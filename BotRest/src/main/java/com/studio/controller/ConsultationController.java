package com.studio.controller;

import com.studio.model.Consultation;
import com.studio.model.Employee;
import com.studio.model.Room;
import com.studio.service.ConsultationService;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/employees/{university_nick}/consultation", method = RequestMethod.GET)
    @ResponseBody
    public List<Consultation> getConsultations(@PathVariable(value = "university_nick", required = true) String university_nick) {
        return consultationService.getConsultationsForEmployee(university_nick);
    }

    @RequestMapping(path = "/employees/{university_nick}/consultation/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Consultation getConsultation(@PathVariable(value = "university_nick", required = true) String university_nick,
                                              @PathVariable(value = "id", required = true) Long id) {
        return consultationService.getConsultationsForEmployee(university_nick)
                .stream()
                .filter(x -> x.id == id)
                .findFirst()
                .get();
    }

    @RequestMapping(path = "/employees/{university_nick}/consultation/{id}/room", method = RequestMethod.GET)
    @ResponseBody
    public Room getConsultationRoom(@PathVariable(value = "university_nick", required = true) String university_nick,
                                        @PathVariable(value = "id", required = true) Long id) {
        return consultationService.getConsultationsForEmployee(university_nick)
                .stream()
                .filter(x -> x.id == id)
                .findFirst()
                .get()
                .getRoom();
    }

    @RequestMapping(path = "/employees/consultation", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Consultation> getEmployeeConsultationByNameAndSurname(@RequestParam(value = "name", required = false) String name,
                                           @RequestParam(value = "surname", required = false) String surname) {
        List<Employee> employees = new LinkedList<>();
        if(name != null && surname != null)
            employees = employeeService.getEmployeesWithNameAndSurname(name, surname);
        if(!employees.isEmpty())
            return consultationService.getConsultationsForEmployee(employees.get(0).getUniversityNick());
        return new LinkedList<Consultation>();
    }

}
