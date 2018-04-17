package com.studio.service.implementation;

import com.studio.model.Score;
import com.studio.model.Student;
import com.studio.model.Subject;
import com.studio.repository.ScoreDAO;
import com.studio.service.ScoreService;
import com.studio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreDAO scoreDAO;

    @Autowired
    SubjectServiceImpl subjectService;

    @Autowired
    StudentService studentService;
    @Override
    public Iterable<Score> getScoresByStudentAndSubject(String index, long subjectId) {
        Student student= studentService.getStudentByIndex(index);
        Subject subject = subjectService.getSubjectById(subjectId);
        return scoreDAO.findAllByStudentAndSubject(student,subject);
    }

    @Override
    public Iterable<Score> getScoresBySubject(long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        return scoreDAO.findAllBySubject(subject);    }
}
