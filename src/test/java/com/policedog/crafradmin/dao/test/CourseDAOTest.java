package com.policedog.crafradmin.dao.test;

import com.policedog.craftadmin.dao.*;
import com.policedog.craftadmin.domain.Admin;
import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.CourseComment;
import com.policedog.craftadmin.domain.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class CourseDAOTest {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private SectionDAO sectionDAO;

    @Autowired
    private CourseCommentDAO courseCommentDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseMSGToStudentDAO courseMSGToStudentDAO;

    @Autowired
    private SelectedCourseDAO selectedCourseDAO;

    @Test
    public void testDeleteCommentByStudentId(){
        String[] ids = {"3"};
        courseCommentDAO.deleteMultiByStudentId(ids);
        courseMSGToStudentDAO.deleteMultiByReciverId(ids);
        selectedCourseDAO.deleteMultiByStudentId(ids);
        studentDAO.deleteMulti(ids);
    }

    @Test
    public void testSelectAll() {
        List<Course> courses = courseDAO.selectAll();
        for (Course course : courses) {
            System.out.println(course.getId());
            System.out.println(course.getCoursename());
        }
    }

    @Test
    public void testSelectByCourseId() {
        List<CourseComment> courseComments = courseCommentDAO.getBycourseId(1L);
        for (CourseComment courseComment:courseComments) {
            System.out.println(courseComment.getComment());
        }
    }

    @Test
    public void testSeclectSectionById(){
        List<Section> sectionList = sectionDAO.getByCourseId(1L);
        for (Section section: sectionList) {
            System.out.println(section.toString());
        }
    }
}
