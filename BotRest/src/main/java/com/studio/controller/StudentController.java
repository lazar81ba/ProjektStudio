package com.studio.controller;

import com.studio.model.Student;

import com.studio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }
}
