package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.dao.CommunityDAO;
import com.policedog.craftadmin.domain.Community;
import com.policedog.craftadmin.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityDAO communityDAO;

    @Override
    public List<Community> selectAll() {
        return communityDAO.selectAll();
    }

    @Override
    public Community getBycommunityId(Long id) {
        return communityDAO.getBycommunityId(id);
    }

    @Override
    public void update(Community community) {
        communityDAO.update(community);
    }

    @Override
    public void deleteMulti(String[] ids) {
        communityDAO.deleteMulti(ids);
    }

    @Override
    public BaseResult save(Community community) {
        BaseResult baseResult = BaseResult.success();
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //成功
            community.setUpdated(new Date());
            if (community.getId()==null){

                community.setCreated(new Date());
                communityDAO.insert(community);
            }else{
                //update用户
                communityDAO.update(community);
            }

            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public List<Community> getSonByFatherId(Long communityid) {
        return communityDAO.getSonByFatherId(communityid);
    }
}
