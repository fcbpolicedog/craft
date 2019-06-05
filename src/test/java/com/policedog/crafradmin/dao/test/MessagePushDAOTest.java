package com.policedog.crafradmin.dao.test;


import com.policedog.craftadmin.dao.SelectedCourseDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class MessagePushDAOTest {

    @Autowired
    private SelectedCourseDAO selectedCourseDAO;
    @Test
    public void testSelectCourse(){
        List<Long> studentIdList = selectedCourseDAO.selectStudentIdByCourseId(1L);
        for (Long studentId: studentIdList) {
            System.out.println(studentId);
        }
    }
}
