package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Section;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionDAO {

    List<Section> selectAll();

    List<Section> getByCourseId(Long courseid);
}
