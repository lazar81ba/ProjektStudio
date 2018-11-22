package com.studio.repository;

import com.studio.model.Consultation;
import com.studio.model.Employee;
import com.studio.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultationDAO extends CrudRepository<Consultation, Long> {
    public Consultation findById(Long id);
    public List<Consultation> findAllByEmployee(Employee employee);
    public List<Consultation> findAllByRoom(Room room);
}
