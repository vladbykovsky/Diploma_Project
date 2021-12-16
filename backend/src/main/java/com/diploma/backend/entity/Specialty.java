package com.diploma.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Specialty {
    private int id;
    private String title;
    private String code;
    private Faculty faculty;

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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return id == specialty.id &&
                Objects.equals(title, specialty.title) &&
                Objects.equals(code, specialty.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, code);
    }
}
