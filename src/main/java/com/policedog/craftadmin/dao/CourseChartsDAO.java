package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.CourseCharts;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseChartsDAO {
    List<CourseCharts> selectAll();

    void insert(CourseCharts courseCharts);

    void delete(Long id);

    CourseCharts getById(Long id);

    void update(CourseCharts courseCharts);

    void deleteMulti(String[] ids);
}
