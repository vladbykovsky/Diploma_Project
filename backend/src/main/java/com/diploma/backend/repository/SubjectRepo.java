package com.diploma.backend.repository;

import com.diploma.backend.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Integer> {
    List<Subject> findAll();
    Subject findById(int id);
}
