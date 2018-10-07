package com.studio.repository;

import com.studio.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDAO extends CrudRepository<Subject,Long> {
    public Subject findFirstByName(String name);
    public Iterable<Subject> findAllByName(String name);

}
