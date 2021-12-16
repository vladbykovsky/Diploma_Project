package com.diploma.backend.repository;

import com.diploma.backend.entity.Absence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AbsenceRepo extends CrudRepository<Absence, Integer> {

    List<Absence> findByStudentByStudentId_Id(int id);
    List<Absence> findByStudentByStudentId_IdAndSubjectBySubjectId_Id(int studentId, int subjectId);
    List<Absence> findByDateAndSubjectBySubjectId_Id(Date date, int id);
    List<Absence> findBySubjectBySubjectId_Id(int id);

}
