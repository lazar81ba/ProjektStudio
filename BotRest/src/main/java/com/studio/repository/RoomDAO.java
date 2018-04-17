package com.studio.repository;

import com.studio.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomDAO extends CrudRepository<Room,Long> {
}
