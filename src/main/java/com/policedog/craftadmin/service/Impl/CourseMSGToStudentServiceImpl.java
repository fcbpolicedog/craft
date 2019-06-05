package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.dao.CourseMSGToStudentDAO;
import com.policedog.craftadmin.dao.SelectedCourseDAO;
import com.policedog.craftadmin.domain.CourseMSGToStudent;
import com.policedog.craftadmin.service.CourseMSGToStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMSGToStudentServiceImpl implements CourseMSGToStudentService {
    @Autowired
    private CourseMSGToStudentDAO courseMSGToStudentDAO;

    @Autowired
    private SelectedCourseDAO selectedCourseDAO;

    @Override
    public List<CourseMSGToStudent> selectAll() {
        return courseMSGToStudentDAO.selectAll();
    }

    @Override
    public void insert(CourseMSGToStudent courseMSGToStudent) {
        courseMSGToStudentDAO.insert(courseMSGToStudent);
    }

    @Override
    public CourseMSGToStudent getById(Long id) {
        return courseMSGToStudentDAO.getById(id);
    }

    @Override
    public void update(CourseMSGToStudent courseMSGToStudent) {
        courseMSGToStudentDAO.update(courseMSGToStudent);
    }

    @Override
    public List<Long> selectStudentIdByCourseId(Long courseId) {
        return selectedCourseDAO.selectStudentIdByCourseId(courseId);
    }

    @Override
    public void deleteMultiByReciverId(String[] ids) {
        courseMSGToStudentDAO.deleteMultiByReciverId(ids);
    }
}
