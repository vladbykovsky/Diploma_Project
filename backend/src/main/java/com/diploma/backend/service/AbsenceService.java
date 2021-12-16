package com.diploma.backend.service;

import com.diploma.backend.entity.Absence;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface AbsenceService {
    List<Absence> findByStudentId(int id);
    List<Absence> findByStudentIdAndSubjectId(int studentId, int subjectId);
    List<Absence> findByDateAndSubjectId(Date date, int id);
    List<Absence> findBySubjectId(int id);
}
