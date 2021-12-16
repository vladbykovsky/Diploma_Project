package com.diploma.backend.service.impl;

import com.diploma.backend.entity.StudentGroup;
import com.diploma.backend.repository.GroupRepo;
import com.diploma.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    public GroupServiceImpl(GroupRepo groupRepo){
        this.groupRepo = groupRepo;
    }

    @Override
    public List<StudentGroup> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public StudentGroup findByTitle(String title) {
        return groupRepo.findByTitle(title);
    }

    @Override
    public List<StudentGroup> findByCourse(int course) {
        return groupRepo.findByCourse(course);
    }

    @Override
    public List<StudentGroup> findBySpecialtyId(int id) {
        return groupRepo.findBySpecialtyId(id);
    }
}
