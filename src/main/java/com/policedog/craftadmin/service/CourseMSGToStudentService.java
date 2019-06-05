package com.policedog.craftadmin.service;

import com.policedog.craftadmin.domain.CourseMSGToStudent;
import java.util.List;

public interface CourseMSGToStudentService {

    List<CourseMSGToStudent> selectAll();

    void insert(CourseMSGToStudent courseMSGToStudent);

    CourseMSGToStudent getById(Long id);

    void update(CourseMSGToStudent courseMSGToStudent);

    List<Long> selectStudentIdByCourseId(Long courseId);

    void deleteMultiByReciverId(String[] ids);
}
