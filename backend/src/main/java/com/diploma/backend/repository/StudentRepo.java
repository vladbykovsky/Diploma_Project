package com.diploma.backend.repository;

import com.diploma.backend.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> getAllByStudentGroupByGroupId_Id(int id);
    Student findById(int id);
    Student findByNameAndSurnameAndStudentGroupByGroupId_Title(String name, String surname, String title);
}
