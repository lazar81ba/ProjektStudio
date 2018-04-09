package com.studio.service;

import com.studio.model.Group;
import com.studio.model.Specialization;
import com.studio.repository.GroupRepository;
import com.studio.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationService {
    @Autowired
    SpecializationRepository specializationRepository;

    public Specialization getSpecialization(Long id){
        return specializationRepository.getSpecialization(id);
    }
}
