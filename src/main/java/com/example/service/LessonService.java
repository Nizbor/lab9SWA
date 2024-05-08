package com.example.service;

import com.example.model.Lesson;

import java.util.List;

public interface LessonService {
    Lesson addLesson(Lesson lesson);
    void delete(Lesson lesson);
    Lesson getById(Integer id);
    List<Lesson> getAllLesson();
    Lesson updateLesson(Lesson lesson);
}
