package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.dao.VideoMSGDAO;
import com.policedog.craftadmin.domain.VideoMSG;
import com.policedog.craftadmin.service.VideoMSGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoMSGServiceImpl implements VideoMSGService {

    @Autowired
    private VideoMSGDAO videoMSGDAO;

    @Override
    public List<VideoMSG> selectAll() {
        List<VideoMSG> videoMSGList = videoMSGDAO.selectAll();
        return videoMSGList;
    }

    @Override
    public void insert(VideoMSG videoMSG) {
        videoMSGDAO.insert(videoMSG);
    }

    @Override
    public void delete(Long id) {
        videoMSGDAO.delete(id);
    }

    @Override
    public void update(VideoMSG videoMSG) {
        videoMSGDAO.update(videoMSG);
    }

    @Override
    public List<VideoMSG> search(String keyword) {
        VideoMSG videoMSG = new VideoMSG();
        videoMSG.setContent(keyword);
        return videoMSGDAO.search(videoMSG);
    }

    @Override
    public void deleteMulti(String[] ids) {
        videoMSGDAO.deleteMulti(ids);
    }

    @Override
    public VideoMSG getById(Long id) {
        return videoMSGDAO.getById(id);
    }

    @Override
    public BaseResult save(VideoMSG videoMSG) {
        BaseResult baseResult = BaseResult.success();
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            if (videoMSG.getId()==null){
                videoMSG.setCreated(new Date());
                videoMSGDAO.insert(videoMSG);
            }else{
                //update视频反馈信息
                videoMSGDAO.update(videoMSG);
            }
            baseResult.setMessage("保存反馈信息成功");
        }
        return baseResult;
    }
}
