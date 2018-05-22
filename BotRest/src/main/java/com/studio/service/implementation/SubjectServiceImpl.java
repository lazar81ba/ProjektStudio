package com.studio.service.implementation;

import com.studio.model.Subject;
import com.studio.repository.SubjectDAO;
import com.studio.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectDAO subjectDAO;
    public Subject getSubjectById(Long id){
        return subjectDAO.findOne(id);
    }
    public Subject getSubjectByName(String name) {return subjectDAO.findFirstByName(name);}
}
