package com.policedog.craftadmin.service;

import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.CourseComment;

import java.util.List;

public interface CourseCommentService {
    List<CourseComment> selectAll();


    List<CourseComment> getBycourseId(Long courseid);

    void update(CourseComment courseComment);


    void deleteMulti(String[] ids);
}
