package com.studio.controller;


import com.studio.model.Score;
import com.studio.model.Student;
import com.studio.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping(path = "/students/{index}/scores/subject/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Score> getStudentScoresBySubject(@PathVariable(value="index", required = true) String index,
                                             @PathVariable(value="id", required = true) long subjectId) {
        return scoreService.getScoresByStudentAndSubject(index,subjectId);
    }

    @RequestMapping(path = "/students/scores/subject/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Score> getScoresBySubject(@PathVariable(value="id", required = true) long subjectId) {
        return scoreService.getScoresBySubject(subjectId);
    }
}
