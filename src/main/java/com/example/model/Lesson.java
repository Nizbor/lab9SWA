package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lesson", schema = "task2")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_lesson", nullable = false)
    private Integer id_lesson;

    @Column (name = "name_lesson", length = 255,  nullable = false)
    private String name_lesson;

    public Lesson(String name_lesson, Integer id_lesson){
        this.name_lesson = name_lesson;
        this.id_lesson = id_lesson;
    }

    public Lesson() {

    }

    public Integer getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(Integer id_lesson) {
        this.id_lesson = id_lesson;
    }

    public String getName_lesson() {
        return name_lesson;
    }

    public void setName_lesson(String name_lesson) {
        this.name_lesson = name_lesson;
    }

    @Override
    public  String toString(){
        return "model.Lesson{" + "NameLesson: " + name_lesson + "}";
    }
}
