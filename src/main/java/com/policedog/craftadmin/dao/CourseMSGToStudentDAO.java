package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.CourseMSGToStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMSGToStudentDAO {

    List<CourseMSGToStudent> selectAll();

    void insert(CourseMSGToStudent courseMSGToStudent);

    CourseMSGToStudent getById(Long id);

    void update(CourseMSGToStudent courseMSGToStudent);

    void deleteMultiByReciverId(String[] ids);
}
