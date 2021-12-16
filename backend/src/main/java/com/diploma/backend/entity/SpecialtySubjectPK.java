package com.diploma.backend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecialtySubjectPK implements Serializable {
    private int specialtyId;
    private int subjectId;

    @Column(name = "specialty_id")
    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Column(name = "subject_id")
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialtySubjectPK that = (SpecialtySubjectPK) o;
        return specialtyId == that.specialtyId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyId, subjectId);
    }
}
