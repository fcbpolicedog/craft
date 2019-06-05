package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Student;
import com.policedog.craftadmin.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectAll();

    BaseResult save(Teacher teacher);

    void delete(Long id);

    Teacher getById(Long id);

    void update(Teacher teacher);

    List<Teacher> selectByUsername(String username);


    List<Teacher> search(String keyword);

    void deleteMulti(String[] ids);
}
