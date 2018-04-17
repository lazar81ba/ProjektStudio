package com.studio.controller;


import com.studio.model.Score;
import com.studio.model.Student;
import com.studio.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping(path = "/getStudentScoresBySubject", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Score> getStudentScoresBySubject(@RequestParam(value="index", required = true) String index,
                                             @RequestParam(value="subjectId", required = true) long subjectId) {
        return scoreService.getScoresByStudentAndSubject(index,subjectId);
    }

    @RequestMapping(path = "/getScoresBySubject", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Score> getScoresBySubject(@RequestParam(value="subjectId", required = true) long subjectId) {
        return scoreService.getScoresBySubject(subjectId);
    }
}
