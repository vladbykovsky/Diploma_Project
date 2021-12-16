package com.diploma.backend.service.impl;

import com.diploma.backend.entity.Specialty;
import com.diploma.backend.repository.SpecialtyRepo;
import com.diploma.backend.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecialtyServiceImpl implements SpecialtyService {
    @Autowired
    private SpecialtyRepo specialtyRepo;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepo specialtyRepo){
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    public List<Specialty> finAll() {
        return specialtyRepo.findAll();
    }

    @Override
    public Specialty findById(int id) {
        return specialtyRepo.findById(id);
    }
}
