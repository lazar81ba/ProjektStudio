package com.studio.service;

import com.studio.model.Subject;

public interface SubjectService {
    Iterable<Subject> getAllSubjects();
    Subject getSubjectById(Long id);
    Iterable<Subject> getSubjectByName(String name);
}
