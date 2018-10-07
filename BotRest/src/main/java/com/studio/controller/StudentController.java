package com.studio.controller;

import com.studio.model.Student;

import com.studio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Student> getAll(@RequestParam(value="groupId", required = false) Long groupId,
                                    @RequestParam(value="subjectId", required = false) Long subjectId) {
            return studentService.getAllStudents();
    }


    @RequestMapping(path = "/students/{index}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable(value="index", required = true) String index) {
        return studentService.getStudentByIndex(index);
    }


    @RequestMapping(path = "/students/group/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Student> getStudentsByGroup(@PathVariable(value="id", required = true) Long id) {
        return studentService.getAllStudentsByGroup(id);
    }

    @RequestMapping(path = "/students/subject/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Student> getStudentsBySubject(@PathVariable(value="id", required = true) Long id) {
        return studentService.getAllStudentsBySubject(id);
    }
}
