package com.studio.service.implementation;

import com.studio.model.Specialization;
import com.studio.repository.SpecializationDAO;
import com.studio.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationServiceImpl implements SpecializationService {
    @Autowired
    SpecializationDAO specializationDAO;

    public Specialization getSpecializationById(long id){
        return specializationDAO.findOne(id);
    }
}
