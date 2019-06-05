package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.dao.CourseCommentDAO;
import com.policedog.craftadmin.domain.CourseComment;
import com.policedog.craftadmin.service.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCommentServiceImpl implements CourseCommentService {
    @Autowired
    private CourseCommentDAO courseCommentDAO;
    @Override
    public List<CourseComment> selectAll() {
        return courseCommentDAO.selectAll();
    }

    @Override
    public List<CourseComment> getBycourseId(Long courseid) {
        return courseCommentDAO.getBycourseId(courseid);
    }

    @Override
    public void update(CourseComment courseComment) {
        courseCommentDAO.update(courseComment);
    }


    @Override
    public void deleteMulti(String[] ids) {
        courseCommentDAO.deleteMulti(ids);
    }
}
