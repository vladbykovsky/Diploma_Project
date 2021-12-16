package com.diploma.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Faculty {
    private int id;
    private String title;
    private String fullTitle;
    private Teacher teacherByDeanId;

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
    @Column(name = "full_title")
    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                Objects.equals(title, faculty.title) &&
                Objects.equals(fullTitle, faculty.fullTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, fullTitle);
    }

    @ManyToOne
    @JoinColumn(name = "dean_id", referencedColumnName = "id", nullable = false)
    public Teacher getTeacherByDeanId() {
        return teacherByDeanId;
    }

    public void setTeacherByDeanId(Teacher teacherByDeanId) {
        this.teacherByDeanId = teacherByDeanId;
    }
}
