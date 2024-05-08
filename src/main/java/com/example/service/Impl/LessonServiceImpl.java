package com.example.service.Impl;

import com.example.model.Lesson;
import com.example.repository.LessonRepository;
import com.example.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl  implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void delete(Lesson lesson) {
        lessonRepository.delete(lesson);
    }

    @Override
    public Lesson getById(Integer id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return (List<Lesson>)  lessonRepository.findAll();
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
