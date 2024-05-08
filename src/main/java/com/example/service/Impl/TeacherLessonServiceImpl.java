package com.example.service.Impl;

import com.example.model.Lesson;
import com.example.model.Teacher;
import com.example.model.TeacherLesson;
import com.example.repository.LessonRepository;
import com.example.repository.TeacherLessonRepository;
import com.example.repository.TeacherRepository;
import com.example.service.TeacherLessonService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherLessonServiceImpl implements TeacherLessonService {

    @Autowired
    private TeacherLessonRepository teacherLessonRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public TeacherLesson addTeacherLesson(TeacherLesson teacherLesson) {
        return teacherLessonRepository.save(teacherLesson);
    }

    @Override
    public void delete(TeacherLesson teacherLesson) {
        teacherLessonRepository.delete(teacherLesson);
    }

    @Override
    public TeacherLesson getById(Integer id) {
        return teacherLessonRepository.findById(id).orElse(null);
    }

    @Override
    public List<TeacherLesson> getAllTeacherLesson() {
        return (List<TeacherLesson>) teacherLessonRepository.findAll();
    }



    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Lesson addlesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public TeacherLesson updateTeacherLesson(TeacherLesson teacherLesson) {
        return teacherLessonRepository.save(teacherLesson);
    }
}
