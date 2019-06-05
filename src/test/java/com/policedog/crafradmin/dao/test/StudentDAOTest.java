package com.policedog.crafradmin.dao.test;

import com.policedog.craftadmin.dao.StudentDAO;
import com.policedog.craftadmin.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class StudentDAOTest {
    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void testSelectAll() {
        List<Student> students = studentDAO.selectAll();
        for (Student student : students) {
            System.out.println(student.getUsername());
        }
    }
}
