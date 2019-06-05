package com.policedog.craftadmin.dao;
import com.policedog.craftadmin.domain.VideoMSG;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 视频反馈信息推送DAO
 */
@Repository
public interface VideoMSGDAO {

    List<VideoMSG> selectAll();

    void insert(VideoMSG videoMSG);

    void delete(Long id);

    VideoMSG getById(Long id);

    void update(VideoMSG videoMSG);

    List<VideoMSG> search(VideoMSG videoMSG);

    void deleteMulti(String[] ids);
}
