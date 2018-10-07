package com.studio.controller;

import com.studio.model.Subject;
import com.studio.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Subject> getSubjects(@RequestParam(value = "name", required = false) String name) {
        if(name!=null)
            return subjectService.getSubjectByName(name);
        return subjectService.getAllSubjects();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Subject getSubjectById(@PathVariable(value="id", required = true) Long id) {
        return subjectService.getSubjectById(id);
    }




}
