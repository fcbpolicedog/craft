package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityDAO {
    List<Community> selectAll();

    void insert(Community community);

    void delete(Long id);

    Community getBycommunityId(Long communityid);

    void update(Community community);

    List<Community> search(Community community);

    void deleteMulti(String[] ids);

    List<Community> getSonByFatherId(Long communityid);
}
