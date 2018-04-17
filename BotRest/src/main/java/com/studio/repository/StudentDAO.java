package com.studio.repository;

import com.studio.model.Group;
import com.studio.model.Student;
import com.studio.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDAO extends CrudRepository<Student,Long> {

    public Student getByIndex(String index);
    public Iterable<Student> findAllByGroup(Group group);

    @Query("select st from Score s inner join s.student st where s.subject=?1")
    public Iterable<Student> findAllBySubject(Subject subject);
}
