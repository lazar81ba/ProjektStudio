package com.studio.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Groups")
@Table(name = "group", schema = "public")
public class Group {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private Integer year;


    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    @OneToMany(mappedBy = "group")
    private Set<Schedule> schedules;

    @ManyToOne
    @JoinColumn(name = "id_specialization",nullable = true)
    private Specialization specialization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
