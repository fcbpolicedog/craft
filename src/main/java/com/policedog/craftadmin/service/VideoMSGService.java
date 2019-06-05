package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.VideoMSG;

import java.util.List;

public interface VideoMSGService {

    List<VideoMSG> selectAll();

    void insert(VideoMSG videoMSG);

    void delete(Long id);

    void update(VideoMSG videoMSG);

    List<VideoMSG> search(String keyword);

    void deleteMulti(String[] ids);

    VideoMSG getById(Long id);

    BaseResult save(VideoMSG videoMSG);
}
