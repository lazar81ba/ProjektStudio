package com.studio.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student",schema = "public")
public class Student {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column
    private String sex;

    @Column(name = "university_index")
    private String index;

    @ManyToOne
    @JoinColumn(name = "id_group",nullable = true)
    private Group group;


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIndex() {
        return index;
    }

    public void setUniversityIndex(String index) {
        this.index = index;
    }


}
