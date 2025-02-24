package com.example.restapi.rest;

import com.example.restapi.entity.Teacher;
import com.example.restapi.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

//    private ITeacherDAO teacherDAO;

    private ITeacherService teacherService;

    @Autowired
    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }
}
