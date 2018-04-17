package com.studio.service.implementation;

import com.studio.model.Room;
import com.studio.repository.RoomDAO;
import com.studio.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDAO roomDAO;

    public Room getRoomById(long id){
        return roomDAO.findOne(id);
    }
}
