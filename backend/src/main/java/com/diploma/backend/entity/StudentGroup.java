package com.diploma.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_group", schema = "bntu_db", catalog = "")
public class StudentGroup {
    private int id;
    private String title;
    private int course;
    private int specialtyId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Basic
    @Column(name = "specialty_id")
    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return id == that.id &&
                course == that.course &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, course);
    }
}
