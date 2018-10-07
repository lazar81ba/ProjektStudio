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
    public Iterable<Subject> getAllSubjects() {return subjectDAO.findAll();}
    public Subject getSubjectById(Long id){
        return subjectDAO.findOne(id);
    }
    public Iterable<Subject> getSubjectByName(String name) {return subjectDAO.findAllByName(name);}
}
