package com.studio.service.implementation;

import com.studio.model.Consultation;
import com.studio.model.Employee;
import com.studio.repository.EmployeeDAO;
import com.studio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getEmployeesWithNameAndSurname(String name, String surname) {
        return employeeDAO.findAllByNameAndSurname(name, surname);
    }

    @Override
    public Employee getEmployeeWithUniversityNick(String university_nick) {
        return employeeDAO.findByUniversityNick(university_nick);
    }
}
