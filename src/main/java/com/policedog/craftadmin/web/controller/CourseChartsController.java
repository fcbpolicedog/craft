package com.policedog.craftadmin.web.controller;

import com.alibaba.fastjson.JSON;
import com.policedog.craftadmin.service.CourseChartsService;
import com.policedog.craftadmin.vo.CourseChartsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/charts")
public class CourseChartsController {

    @Autowired
    private CourseChartsService courseChartsService;

    @RequestMapping("/list")
    public String list(Model model){
        List<CourseChartsVO> courseChartsVOList = courseChartsService.selectAll();
        model.addAttribute("courseChartsVOList",courseChartsVOList);
        return "charts_list";
    }

    @RequestMapping(value = "/clicks",method = RequestMethod.GET)
    public String clicks(Model model){
        List<CourseChartsVO> courseChartsVOList = courseChartsService.selectAll();
        List<Object[]> datas = new ArrayList<>();
        for (CourseChartsVO vo : courseChartsVOList) {
            datas.add(new Object[]{vo.getCoursename(),vo.getClicks()});
        }
        model.addAttribute("datas", JSON.toJSONString(datas));
        return "charts_clicks";
    }

    @RequestMapping(value = "/totaltime",method = RequestMethod.GET)
    public String totaltime(Model model){
        List<CourseChartsVO> courseChartsVOList = courseChartsService.selectAll();
        List<Object[]> data = new ArrayList<>();
        for (CourseChartsVO vo : courseChartsVOList) {
            data.add(new Object[]{vo.getCoursename(),vo.getTotaltime()});
        }
        model.addAttribute("data", JSON.toJSONString(data));
        return "charts_totaltime";
    }
}
