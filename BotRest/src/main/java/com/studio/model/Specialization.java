package com.studio.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialization",schema = "public")
public class Specialization {
    @Id
    private long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "specialization")
    private Set<Group> groups =new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
