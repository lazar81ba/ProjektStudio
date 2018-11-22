package com.studio.service.implementation;

import com.studio.model.Consultation;
import com.studio.repository.ConsultationDAO;
import com.studio.repository.EmployeeDAO;
import com.studio.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    ConsultationDAO consultationDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Consultation> getConsultationsForEmployee(String university_nick) {
        return consultationDAO.findAllByEmployee(employeeDAO.findByUniversityNick(university_nick));
    }
}
