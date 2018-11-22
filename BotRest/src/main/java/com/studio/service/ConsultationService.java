package com.studio.service;

import com.studio.model.Consultation;
import com.studio.model.Employee;

import java.util.List;

public interface ConsultationService {
    public List<Consultation> getConsultationsForEmployee(String university_nick);
}
