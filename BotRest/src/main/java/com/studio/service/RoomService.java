package com.studio.service;

import com.studio.model.Room;
import com.studio.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public Room getRoom(Long id){
        return roomRepository.getRoomById(id);
    }
}
