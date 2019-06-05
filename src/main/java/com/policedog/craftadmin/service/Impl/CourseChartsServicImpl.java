package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.dao.CourseChartsDAO;
import com.policedog.craftadmin.dao.CourseDAO;
import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.CourseCharts;
import com.policedog.craftadmin.service.CourseChartsService;
import com.policedog.craftadmin.vo.CourseChartsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseChartsServicImpl implements CourseChartsService {

    @Autowired
    private CourseChartsDAO courseChartsDAO;
    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<CourseChartsVO> selectAll() {
        List<CourseCharts> courseChartsList = courseChartsDAO.selectAll();
        List<CourseChartsVO> courseChartsVOList = new ArrayList<>();
        for (CourseCharts courseCharts : courseChartsList) {
            Long courseid = courseCharts.getCourseid();
            Course course = courseDAO.getById(courseid);
            String coursename = course.getCoursename();
            CourseChartsVO courseChartsVO = new CourseChartsVO();
            courseChartsVO.setId(courseCharts.getId());
            courseChartsVO.setCoursename(coursename);
            courseChartsVO.setClicks(courseCharts.getClicks());
            courseChartsVO.setTotaltime(courseCharts.getTotaltime());
            courseChartsVOList.add(courseChartsVO);
        }
        return courseChartsVOList;
    }

    @Override
    public void insert(CourseCharts courseCharts) {
        courseChartsDAO.insert(courseCharts);
    }

    @Override
    public void delete(Long id) {
        courseChartsDAO.delete(id);
    }

    @Override
    public void update(CourseCharts courseCharts) {
        courseChartsDAO.update(courseCharts);
    }

    @Override
    public void deleteMulti(String[] ids) {
        courseChartsDAO.deleteMulti(ids);
    }

    @Override
    public CourseCharts getById(Long id) {
        return courseChartsDAO.getById(id);
    }

    @Override
    public BaseResult save(CourseCharts courseCharts) {
        return null;
    }
}
