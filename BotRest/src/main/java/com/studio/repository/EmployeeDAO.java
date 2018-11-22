package com.studio.repository;

import com.studio.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDAO extends CrudRepository<Employee,Long>
{
    public Employee findById(Long id);
    public Employee findByUniversityNick(String universityNick);
    public List<Employee> findAllByNameAndSurname(String name, String surname);
}
