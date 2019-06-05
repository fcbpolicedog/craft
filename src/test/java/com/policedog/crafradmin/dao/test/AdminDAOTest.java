package com.policedog.crafradmin.dao.test;

import com.policedog.craftadmin.dao.AdminDAO;
import com.policedog.craftadmin.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class AdminDAOTest {
    @Autowired
    private AdminDAO adminDAO;

    @Test
    public void testSelectAll() {
        List<Admin> admins = adminDAO.selectAll();
        for (Admin admin : admins) {
            System.out.println(admin.getUsername());
        }
    }

    @Test
    public void testSelectByName() {
        List<Admin> admins = adminDAO.selectByUsername("e");
        for (Admin admin : admins) {
            System.out.println(admin.getUsername());
        }
    }

    @Test
    public void testSelectByEmail() {
        Admin admin = adminDAO.getByEmail("admin@policedog.com");
        System.out.println(admin.getUsername());
        System.out.println(admin.getEmail());

    }
}
