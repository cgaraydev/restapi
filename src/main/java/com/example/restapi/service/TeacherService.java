package com.example.restapi.service;

import com.example.restapi.dao.ITeacherDAO;
import com.example.restapi.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    private ITeacherDAO teacherDAO;

    @Autowired
    public TeacherService(ITeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherDAO.findById(id);
    }

    @Override
    @Transactional
    public Teacher update(Teacher teacher) {
        return teacherDAO.update(teacher);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        teacherDAO.deleteById(id);
    }

}
