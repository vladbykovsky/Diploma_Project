package com.diploma.backend.service;

import com.diploma.backend.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> finAll();
    Specialty findById(int id);
}
