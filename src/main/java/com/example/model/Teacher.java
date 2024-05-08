package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher", schema = "task2")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_teacher", nullable = false)
    private Integer id_teacher;

    @Column (name = "first_name", length = 255,  nullable = false)
    private String first_name;

    @Column (name = "last_name", length = 255,  nullable = false)
    private String last_name;

    public Teacher(String first_name, String last_name,  Integer id_teacher){
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_teacher = id_teacher;
    }

    public Teacher() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    @Override
    public  String toString(){
        return "model.Teacher{" + "FirstName" + first_name + "LastName" + last_name + "}";
    }

}
