package com.studio.service;

import com.studio.model.Student;
import com.studio.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentByIndex(String index){
        return studentRepository.getStudentByIndex(index);
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

}
