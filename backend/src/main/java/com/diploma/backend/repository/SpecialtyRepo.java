package com.diploma.backend.repository;

import com.diploma.backend.entity.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepo extends CrudRepository<Specialty, Integer> {
    List<Specialty> findAll();
    Specialty findById(int id);
}
