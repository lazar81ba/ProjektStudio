package com.studio.service;

import com.studio.model.Consultation;
import com.studio.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployeesWithNameAndSurname(String name, String surname);
    public Employee getEmployeeWithUniversityNick(String university_nick);
}
