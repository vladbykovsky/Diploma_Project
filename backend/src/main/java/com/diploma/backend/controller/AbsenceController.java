package com.diploma.backend.controller;

import com.diploma.backend.entity.Absence;
import com.diploma.backend.entity.Student;
import com.diploma.backend.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/absence")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @RequestMapping(value = "/studentId/{studentId}", method = RequestMethod.GET)
    public List<Absence> getAbsenceByStudentId(@PathVariable(name="studentId") int studentId) {
        return absenceService.findByStudentId(studentId);
    }

    @RequestMapping(value = "/subjectId/{subjectId}", method = RequestMethod.GET)
    public List<Absence> getAbsenceBySubjectId(@PathVariable(name="subjectId") int subjectId) {
        return absenceService.findBySubjectId(subjectId);
    }

    @RequestMapping(value = "/studentId/{studentId}/subjectId/{subjectId}", method = RequestMethod.GET)
    public List<Absence> getAbsenceByStudentAndSubject(@PathVariable(name="studentId") int studentId,
                                                 @PathVariable(name="subjectId") int subjectId){
        return absenceService.findByStudentIdAndSubjectId(studentId, subjectId);
    }

    @RequestMapping(value = "/date/{date}/subjectId/{subjectId}", method = RequestMethod.GET)
    public List<Absence> getAbsenceByDateAndSubject(@PathVariable(name="date")
                                                           @DateTimeFormat(pattern = "yyyy.MM.dd") Date date,
                                                 @PathVariable(name="subjectId") int subjectId){
        return absenceService.findByDateAndSubjectId(date, subjectId);
    }
}
