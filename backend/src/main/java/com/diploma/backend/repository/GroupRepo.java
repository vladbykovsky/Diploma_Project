package com.diploma.backend.repository;

import com.diploma.backend.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends CrudRepository<StudentGroup, Integer> {
    List<StudentGroup> findAll();
    StudentGroup findByTitle(String title);
    List<StudentGroup> findByCourse(int course);
    List<StudentGroup> findBySpecialtyId(int id);
}
