package com.example.restapi.rest;

import com.example.restapi.entity.Teacher;
import com.example.restapi.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private ITeacherService teacherService;

    @Autowired
    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) throw new RuntimeException("Teacher id not found - " + id);
        return teacher;
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        teacher.setId(0);
        Teacher teacherDB = teacherService.save(teacher);
        return teacherDB;
    }

    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        Teacher teacherDB = teacherService.save(teacher);
        return teacherDB;
    }

    @DeleteMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) throw new RuntimeException("Teacher id not found - " + id);
        teacherService.deleteById(id);
        return "Deleted teacher id - " + id;
    }

}
