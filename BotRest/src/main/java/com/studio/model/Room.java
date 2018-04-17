package com.studio.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room",schema = "public")
public class Room {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String building;
    @Column
    private Integer level;

    @OneToMany(mappedBy = "room")
    private Set<Schedule> schedules=new HashSet<>();

    @OneToMany(mappedBy = "room")
    private Set<Employee> employees=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
