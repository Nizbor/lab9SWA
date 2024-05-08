package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_lesson", schema = "task2")
public class TeacherLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher_lesson",  nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_teacher", nullable = false)
    private Teacher id_teacher;

    @ManyToOne
    @JoinColumn(name = "id_lesson",  nullable = false)
    private Lesson id_lesson;

    public Integer getId() {
        return id;
    }

    public Lesson getLesson() {
        return id_lesson;
    }

    public Teacher getTeacher() {
        return id_teacher;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLesson(Lesson lesson) {
        this.id_lesson = lesson;
    }

    public void setTeacher(Teacher teacher) {
        this.id_teacher = teacher;
    }
}