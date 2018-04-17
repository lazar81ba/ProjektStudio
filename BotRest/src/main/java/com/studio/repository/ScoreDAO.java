package com.studio.repository;

import com.studio.model.Score;
import com.studio.model.Student;
import com.studio.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface ScoreDAO extends CrudRepository<Score,Long> {
    public Iterable<Score> findAllByStudentAndSubject(Student student, Subject subject);
    public Iterable<Score> findAllBySubject(Subject subject);

}
