package com.studio.service.implementation;

import com.studio.model.Group;
import com.studio.model.Student;
import com.studio.model.Subject;
import com.studio.repository.StudentDAO;
import com.studio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    GroupServiceImpl groupServiceImpl;
    @Autowired
    SubjectServiceImpl subjectService;

    public Student getStudentByIndex(String index){
        return studentDAO.getByIndex(index);
    }

    public Iterable<Student> getAllStudents(){
        return studentDAO.findAll();
    }

    public Iterable<Student> getAllStudentsByGroup(long groupId){
        Group group = groupServiceImpl.getGroupById(groupId);
        return studentDAO.findAllByGroup(group);
    }

    @Override
    public Iterable<Student> getAllStudentsBySubject(long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        return studentDAO.findAllBySubject(subject);
    }

}
