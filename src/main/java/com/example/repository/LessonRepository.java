package com.example.repository;

import com.example.model.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
