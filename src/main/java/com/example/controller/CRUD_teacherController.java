package com.example.controller;


import com.example.model.Lesson;
import com.example.model.Teacher;
import com.example.model.TeacherLesson;
import com.example.service.LessonService;
import com.example.service.TeacherLessonService;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/CRUD_teacher")
@PreAuthorize("hasAuthority('admin')")
public class CRUD_teacherController {

    @Autowired
    private TeacherLessonService teacherLessonService;

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model){
        model.addAttribute("teacherLesson", teacherLessonService.getById(id));
        return "CRUD_teacher/editTeacher";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("teacher") Teacher teacher,
                           @ModelAttribute("lesson")  Lesson lesson,
                           @RequestParam Integer id){
        TeacherLesson empteacherLesson = teacherLessonService.getById(id);

        Teacher empteacher = empteacherLesson.getTeacher();
        Lesson emplesson = empteacherLesson.getLesson();

        if(!lesson.getName_lesson().isEmpty()) emplesson.setName_lesson(lesson.getName_lesson());
        if(!teacher.getFirst_name().isEmpty()) empteacher.setFirst_name(teacher.getFirst_name());
        if(!teacher.getLast_name().isEmpty()) empteacher.setLast_name(teacher.getLast_name());

        empteacherLesson.setTeacher(empteacher);
        empteacherLesson.setLesson(emplesson);

        teacherLessonService.addTeacher(empteacher);
        teacherLessonService.addlesson(emplesson);
        teacherLessonService.updateTeacherLesson(empteacherLesson);

        return "redirect:/profile/unListAdmin";

    }

    @GetMapping("/createTeacher")
    public String create(){
        return "CRUD_teacher/createTeacher";
    }

    @PostMapping("/createTeacher")
    public String createTeacher(@ModelAttribute Teacher teacher,
                                @ModelAttribute Lesson lesson){

        System.out.println(lesson.getName_lesson());
        teacherLessonService.addlesson(lesson);
        teacherLessonService.addTeacher(teacher);

        TeacherLesson teacherLesson = new TeacherLesson();
        teacherLesson.setLesson(lesson);
        teacherLesson.setTeacher(teacher);

        teacherLessonService.addTeacherLesson(teacherLesson);

        return "redirect:/profile/unList";
    }
}
