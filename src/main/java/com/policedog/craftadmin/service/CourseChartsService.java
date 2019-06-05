package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.CourseCharts;
import com.policedog.craftadmin.vo.CourseChartsVO;

import java.util.List;

public interface CourseChartsService {

    List<CourseChartsVO> selectAll();

    void insert(CourseCharts courseCharts);

    void delete(Long id);

    void update(CourseCharts courseCharts);


    void deleteMulti(String[] ids);

    CourseCharts getById(Long id);

    BaseResult save(CourseCharts courseCharts);
}
