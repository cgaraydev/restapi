package com.example.restapi.dao;

import com.example.restapi.entity.Teacher;
import java.util.List;

public interface ITeacherDAO {

    public List<Teacher> findAll();
    public Teacher findById(int id);
    public Teacher update(Teacher teacher);
    public void deleteById(int id);

}
