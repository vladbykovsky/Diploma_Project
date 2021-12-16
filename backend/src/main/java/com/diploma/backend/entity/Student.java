package com.diploma.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private String gender;
    private String birthday;
    private String city;
    private String telephone;
    private String mail;
    private StudentGroup studentGroupByGroupId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(middleName, student.middleName) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(birthday, student.birthday) &&
                Objects.equals(city, student.city) &&
                Objects.equals(telephone, student.telephone) &&
                Objects.equals(mail, student.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, middleName, gender, birthday, city, telephone, mail);
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public StudentGroup getStudentGroupByGroupId() {
        return studentGroupByGroupId;
    }

    public void setStudentGroupByGroupId(StudentGroup studentGroupByGroupId) {
        this.studentGroupByGroupId = studentGroupByGroupId;
    }
}
