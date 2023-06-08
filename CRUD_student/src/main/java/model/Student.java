package model;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private Date dob;
    private Gender gender;
    private StudentClass studentClass;

    public Student(String name, Date dob, Gender gender, StudentClass studentClass) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.studentClass = studentClass;
    }

    public Student(int id, String name, Date dob, Gender gender, StudentClass studentClass) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.studentClass = studentClass;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
