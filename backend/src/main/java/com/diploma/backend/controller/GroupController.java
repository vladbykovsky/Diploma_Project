package com.diploma.backend.controller;

import com.diploma.backend.entity.StudentGroup;
import com.diploma.backend.entity.Teacher;
import com.diploma.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StudentGroup> getAllGroups() {
        return groupService.findAll();
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public StudentGroup getGroupByTitle(@PathVariable(name="title") String title){
        return groupService.findByTitle(title);
    }

    @RequestMapping(value = "/course/{course}", method = RequestMethod.GET)
    public List<StudentGroup> getGroupByCourse(@PathVariable(name="course") int course){
        return groupService.findByCourse(course);
    }

    @RequestMapping(value = "/specialtyId/{id}", method = RequestMethod.GET)
    public List<StudentGroup> getGroupBySpecialtyId(@PathVariable(name="id") int id){
        return groupService.findBySpecialtyId(id);
    }
}
