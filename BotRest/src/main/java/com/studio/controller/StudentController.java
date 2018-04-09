package com.studio.controller;

import com.studio.model.Student;

import com.studio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/getStudent", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@RequestParam(value="index", required = true) String index) {
        return studentService.getStudentByIndex(index);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }
}
