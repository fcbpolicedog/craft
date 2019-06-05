package com.policedog.crafradmin.dao.test;

import com.policedog.craftadmin.dao.CommunityDAO;
import com.policedog.craftadmin.domain.Community;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class CommunityDAOTest {

    @Autowired
    private CommunityDAO communityDAO;


    @Test
    public void testSelectAll(){
        List<Community> communities = communityDAO.selectAll();
        for (Community community: communities) {
            System.out.println(community.getContent());
        }
    }

    @Test
    public void testSelect(){
        List<Community> communities = communityDAO.getSonByFatherId(1L);
        for (Community community: communities) {
            System.out.println(community.getContent());
        }
    }
}
