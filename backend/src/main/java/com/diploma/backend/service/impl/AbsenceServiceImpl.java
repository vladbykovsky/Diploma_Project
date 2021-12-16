package com.diploma.backend.service.impl;

import com.diploma.backend.entity.Absence;
import com.diploma.backend.repository.AbsenceRepo;
import com.diploma.backend.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Component
public class AbsenceServiceImpl implements AbsenceService {
    @Autowired
    private AbsenceRepo absenceRepo;

    @Autowired
    public AbsenceServiceImpl(AbsenceRepo absenceRepo){
        this.absenceRepo = absenceRepo;
    }

    @Override
    public List<Absence> findByStudentId(int id) {
        return absenceRepo.findByStudentByStudentId_Id(id);
    }

    @Override
    public List<Absence> findByStudentIdAndSubjectId(int studentId, int subjectId) {
        return absenceRepo.findByStudentByStudentId_IdAndSubjectBySubjectId_Id(studentId, subjectId);
    }

    @Override
    public List<Absence> findByDateAndSubjectId(Date date, int id) {
        return absenceRepo.findByDateAndSubjectBySubjectId_Id(date, id);
    }

    @Override
    public List<Absence> findBySubjectId(int id) {
        return absenceRepo.findBySubjectBySubjectId_Id(id);
    }
}
