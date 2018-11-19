package com.studio.controller;

import com.studio.model.Consultation;
import com.studio.model.Room;
import com.studio.service.ConsultationService;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

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

}
