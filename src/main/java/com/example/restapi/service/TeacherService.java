package com.example.restapi.service;

import com.example.restapi.dao.TeacherRepository;
import com.example.restapi.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        Optional<Teacher> result = teacherRepository.findById(id);
        Teacher teacher = null;
        if (result.isPresent()) teacher = result.get();
        else throw new RuntimeException("Did not find teacher id - " + id);
        return teacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }

}
