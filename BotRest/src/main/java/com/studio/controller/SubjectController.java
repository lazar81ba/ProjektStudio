package com.studio.controller;

import com.studio.model.Subject;
import com.studio.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @RequestMapping(path = "/subjects/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Subject getSubjectByName(@PathVariable(value="name", required = true) String name) {
        return subjectService.getSubjectByName(name);
    }
}
