package com.diploma.backend.repository;

import com.diploma.backend.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
    List<Teacher> findAll();
    Teacher findByNameAndSurnameAndMiddleName(String name, String surname, String middleName);
}
