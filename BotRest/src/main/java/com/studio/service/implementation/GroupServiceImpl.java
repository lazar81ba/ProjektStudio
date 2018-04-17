package com.studio.service.implementation;

import com.studio.model.Group;
import com.studio.repository.GroupDAO;
import com.studio.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDAO groupDAO;

    public Group getGroupById(long id){
        return groupDAO.findOne(id);
    }
}
