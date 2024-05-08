package com.example.service;

import com.example.model.Lesson;
import com.example.model.Teacher;
import com.example.model.TeacherLesson;


import java.util.List;

public interface TeacherLessonService {
    TeacherLesson addTeacherLesson(TeacherLesson teacherLesson);
    void delete(TeacherLesson teacherLesson);
    TeacherLesson getById(Integer id);
    List<TeacherLesson> getAllTeacherLesson();
    TeacherLesson updateTeacherLesson(TeacherLesson teacherLesson);

    Teacher addTeacher(Teacher teacher);
    Lesson addlesson(Lesson lesson);
}
