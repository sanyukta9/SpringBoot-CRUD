package com.example.Task1.StudentData.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "StudentData")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studId;

    @Column(name = "firstname")
    private String studFname;

    @Column(name = "Lastname")
    private String studLname;

    @Column(name = "Coursename")
    private String courseName;

    // Default constructor
    public Student() {
    }

    /*
    Parameterized constructor
    public Student(Integer studId, String studFname, String studLname, String courseName) {
        this.studId = studId;
        this.studFname = studFname;
        this.studLname = studLname;
        this.courseName = courseName;
    }
     */

    // Getter methods
    public Integer getStudId() {
        return studId;
    }

    public String getStudFname() {
        return studFname;
    }

    public String getStudLname() {
        return studLname;
    }

    public String getCourseName() {
        return courseName;
    }

    // Setter methods
    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public void setStudFname(String studFname) {
        this.studFname = studFname;
    }

    public void setStudLname(String studLname) {
        this.studLname = studLname;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // To display
    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", studFname='" + studFname + '\'' +
                ", studLname='" + studLname + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
