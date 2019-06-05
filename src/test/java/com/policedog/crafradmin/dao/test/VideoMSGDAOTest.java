package com.policedog.crafradmin.dao.test;

import com.policedog.craftadmin.dao.VideoMSGDAO;
import com.policedog.craftadmin.domain.VideoMSG;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class VideoMSGDAOTest {

    @Autowired
    private VideoMSGDAO videoMSGDAO;

    @Test
    public void testVideoMSGDAO(){
        List<VideoMSG> videoMSGList = videoMSGDAO.selectAll();
        for (VideoMSG videoMSG: videoMSGList) {
            System.out.println(videoMSG.toString());
        }
    }
}
