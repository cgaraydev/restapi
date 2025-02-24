package com.example.restapi.service;

import com.example.restapi.entity.Teacher;

import java.util.List;

public interface ITeacherService {

    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher update(Teacher teacher);
    void deleteById(int id);
}
