package com.studio.model;

import javax.persistence.*;

@Entity
@Table(name = "score",schema = "public")
public class Score {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private Double value;

    @ManyToOne
    @JoinColumn(name = "id_subject",nullable = true)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_student",nullable = true)
    private Student student;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
