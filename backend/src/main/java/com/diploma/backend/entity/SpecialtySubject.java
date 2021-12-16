//package com.diploma.backend.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "specialty_subject", schema = "bntu_db", catalog = "")
//@IdClass(SpecialtySubjectPK.class)
//public class SpecialtySubject {
//
//    @EmbeddedId
//    SpecialtySubjectPK id;
//
//    @ManyToOne
//    @MapsId("specialty_id")
//    @JoinColumn(name = "specialty_id")
//    Specialty specialty;
//
//    @ManyToOne
//    @MapsId("subject_id")
//    @JoinColumn(name = "subject_id")
//    Subject subject;
//
//
//    @Id
//    @Column(name = "specialty_id")
//    public int getSpecialtyId() {
//        return specialtyId;
//    }
//
//    public void setSpecialtyId(int specialtyId) {
//        this.specialtyId = specialtyId;
//    }
//
//    @Id
//    @Column(name = "subject_id")
//    public int getSubjectId() {
//        return subjectId;
//    }
//
//    public void setSubjectId(int subjectId) {
//        this.subjectId = subjectId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SpecialtySubject that = (SpecialtySubject) o;
//        return specialtyId == that.specialtyId &&
//                subjectId == that.subjectId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(specialtyId, subjectId);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
//    public Subject getSubjectBySubjectId() {
//        return subjectBySubjectId;
//    }
//
//    public void setSubjectBySubjectId(Subject subjectBySubjectId) {
//        this.subjectBySubjectId = subjectBySubjectId;
//    }
//}
