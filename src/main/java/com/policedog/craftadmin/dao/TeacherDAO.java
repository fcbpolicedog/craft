package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Student;
import com.policedog.craftadmin.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDAO {
    List<Teacher> selectAll();

    void insert(Teacher teacher);

    void delete(Long id);

    Teacher getById(Long id);

    void update(Teacher teacher);

    List<Teacher> selectByUsername(String username);

    Teacher getByEmail(String email);

    List<Teacher> search(Teacher teacher);

    void deleteMulti(String[] ids);
}
