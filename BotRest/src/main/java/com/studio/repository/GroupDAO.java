package com.studio.repository;

import com.studio.model.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupDAO extends CrudRepository<Group,Long> {
}
