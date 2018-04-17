package com.studio.service;

import com.studio.model.Student;

import java.util.List;

public interface StudentService {

    public Student getStudentByIndex(String index);
    public Iterable<Student> getAllStudents();
    public Iterable<Student> getAllStudentsByGroup(long groupId);
    public Iterable<Student> getAllStudentsBySubject(long subjectId);

}
