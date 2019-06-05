package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.CourseComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCommentDAO {
    List<CourseComment> selectAll();

    void insert(CourseComment courseComment);


    void delete(Long id);

    List<CourseComment> getBycourseId(Long courseid);

    void update(CourseComment courseComment);

    List<CourseComment> search(Course courseComment);

    void deleteMulti(String[] ids);

    void deleteMultiByStudentId(String[] ids);
}
