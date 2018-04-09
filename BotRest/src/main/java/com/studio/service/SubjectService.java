package com.studio.service;

import com.studio.model.Subject;
import com.studio.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public Subject getSubject(Long id){
        return subjectRepository.getSubjectById(id);
    }
}
