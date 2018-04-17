package com.studio.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subject",schema = "public")
public class Subject {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String description;

    @OneToMany(mappedBy = "subject")
    private Set<Score> scores = new HashSet<>();
    @OneToMany(mappedBy = "subject")
    private Set<Schedule> schedules = new HashSet<>();
    @ManyToMany(mappedBy = "subjects")
    private Set<Employee> employees = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
