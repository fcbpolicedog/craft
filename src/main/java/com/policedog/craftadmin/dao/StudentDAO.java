package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {

    /**
     * 查询全部用户信息
     * @return
     */
    List<Student> selectAll();

    void insert(Student student);

    void delete(Long id);

    Student getById(Long id);

    void update(Student student);

    List<Student> selectByUsername(String username);


    Student getByEmail(String email);

    List<Student> search(Student student);

    void deleteMulti(String[] ids);
}
