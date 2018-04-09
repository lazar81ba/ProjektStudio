package com.studio.service;

import com.studio.model.Group;
import com.studio.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public Group getGroup(Long id){
        return groupRepository.getGroupById(id);
    }
}
