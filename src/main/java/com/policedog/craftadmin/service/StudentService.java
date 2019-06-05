package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAll();

    BaseResult save(Student student);

    void delete(Long id);

    Student getById(Long id);

    void update(Student student);

    List<Student> selectByUsername(String username);

    //Student login(String email,String password);

    List<Student> search(String keyword);

    void deleteMulti(String[] ids);
}
