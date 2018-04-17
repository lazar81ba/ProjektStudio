package com.studio.controller;

import com.studio.model.Student;

import com.studio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/getStudent", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@RequestParam(value="index", required = true) String index) {
        return studentService.getStudentByIndex(index);
    }

    @RequestMapping(path = "/getAllStudents", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Student> getAll() {
        return studentService.getAllStudents();
    }

    @RequestMapping(path = "/getAllStudentsByGroup", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Student> getStudentsByGroup(@RequestParam(value="groupId", required = true) long groupId) {
        return studentService.getAllStudentsByGroup(groupId);
    }

    @RequestMapping(path = "/getAllStudentsBySubject", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Student> getStudentsBySubject(@RequestParam(value="subjectId", required = true) long subjectId) {
        return studentService.getAllStudentsBySubject(subjectId);
    }
}
