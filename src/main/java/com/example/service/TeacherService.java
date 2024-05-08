package com.example.service;

import com.example.model.Teacher;
import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);
    void delete(Teacher teacher);
    Teacher getById(Integer id);
    List<Teacher> getAllTeacher();
    Teacher updateTeacher(Teacher teacher);



}
