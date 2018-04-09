package com.studio.service;

import com.studio.model.Consultation;
import com.studio.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Consultation getEmployeeConsultation(String name, String surname){
        return employeeRepository.getConsultationByName(name,surname);
    }
}
