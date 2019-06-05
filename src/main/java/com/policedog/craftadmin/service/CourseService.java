package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.Section;
import com.policedog.craftadmin.domain.Student;
import com.policedog.craftadmin.vo.CourseVO;

import java.util.List;

public interface CourseService {

    List<CourseVO> selectAll();

    void insert(Course course);

    void delete(Long id);

    void update(Course course);

    List<CourseVO> search(String keyword);

    void deleteMulti(String[] ids);

    Course getById(Long id);

    BaseResult save(Course course);

    List<Section> getByCourseId(Long id);

    List<CourseVO> getByTeacherId(Long teacherid);
}
