package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Community;

import java.util.List;

public interface CommunityService {

    List<Community> selectAll();

    Community getBycommunityId(Long id);

    void update(Community community);

    void deleteMulti(String[] ids);

    BaseResult save(Community community);

    List<Community> getSonByFatherId(Long communityid);
}
