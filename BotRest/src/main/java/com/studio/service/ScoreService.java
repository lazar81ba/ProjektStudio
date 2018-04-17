package com.studio.service;

import com.studio.model.Score;

import java.util.List;

public interface ScoreService {
    public Iterable<Score> getScoresByStudentAndSubject(String index, long subjectId);
    public Iterable<Score> getScoresBySubject( long subjectId);

}
