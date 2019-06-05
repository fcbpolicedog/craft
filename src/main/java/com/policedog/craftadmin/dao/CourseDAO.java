package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseDAO {

    List<Course> selectAll();

    void insert(Course course);

    void delete(Long id);

    Course getById(Long id);

    List<Course> getByTeacherId(Long teacherid);

    void update(Course course);

    List<Course> selectByCoursename(String coursename);

    List<Course> search(Course course);

    void deleteMulti(String[] ids);
}
