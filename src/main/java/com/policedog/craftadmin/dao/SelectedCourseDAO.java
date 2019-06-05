package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.SelectedCourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectedCourseDAO {

    List<SelectedCourse> selectAll();

    List<Long> selectStudentIdByCourseId(Long courseid);

    void insert(SelectedCourse selectedCourse);

    void deleteMultiByStudentId(String[] ids);

    void deleteMultiByCourseId(String[] ids);
}
