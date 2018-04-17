package com.studio.repository;

import com.studio.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDAO extends CrudRepository<Subject,Long> {
}
