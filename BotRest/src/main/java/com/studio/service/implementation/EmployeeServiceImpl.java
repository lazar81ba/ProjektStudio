package com.studio.service.implementation;

import com.studio.model.Consultation;
import com.studio.model.Employee;
import com.studio.repository.EmployeeDAO;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public Consultation getEmployeeConsultation(String university_nick){
        Employee employee = employeeDAO.findByUniversityNick(university_nick);
        return new Consultation(employee.getStartConsultationTime(),employee.getEndConsultationTime()
                ,employee.getConsultationDay(),employee.getRoom());
    }
}
