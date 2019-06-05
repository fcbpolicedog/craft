package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.CourseComment;
import com.policedog.craftadmin.domain.Section;
import com.policedog.craftadmin.service.CourseCommentService;
import com.policedog.craftadmin.service.CourseService;
import com.policedog.craftadmin.vo.CourseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseCommentService courseCommentService;


    @ModelAttribute
    public Course getStudent(Long id){
        Course course = null;
        //id不为空，则从数据库获取
        if (id!=null){
            course = courseService.getById(id);
        }else {
            course = new Course();
        }
        return course;
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String courseList(Model model){
        List<CourseVO> courseVOList = courseService.selectAll();
        model.addAttribute("courseVOList",courseVOList);
        return "course_list";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchCourse(String keyword,Model model){
        List<CourseVO> courseVOList = courseService.search(keyword);
        model.addAttribute("courseVOList",courseVOList);
        return "course_test";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "course_form";
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(Model model, HttpServletRequest request){
        Long courseid = Long.valueOf(request.getParameter("id"));
        List<CourseComment> courseCommentList = courseCommentService.getBycourseId(courseid);
        model.addAttribute("courseCommentList",courseCommentList);
        return "course_detail";
    }


    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Course course, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = courseService.save(course);
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/course/test";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "course_form";
        }
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Model model){
        List<CourseVO> courseVOList = courseService.selectAll();
        model.addAttribute("courseVOList",courseVOList);
        return "course_test";
    }

    @RequestMapping(value = "/testdetail",method = RequestMethod.GET)
    public String testDetail(Model model,HttpServletRequest request){
//        List<CourseVO> courseVOList = courseService.selectAll();
//        model.addAttribute("courseVOList",courseVOList);
        Long courseid = Long.valueOf(request.getParameter("id"));
        //获取课程对象
        Course course = courseService.getById(courseid);

        model.addAttribute("course",course);
        //获取章节列表
        List<Section> sectionList = courseService.getByCourseId(courseid);
        model.addAttribute("sectionList",sectionList);

        return "course_detail_test";
    }

    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public String comment(Model model,HttpServletRequest request){
        Long courseid = Long.valueOf(request.getParameter("id"));
        //获取课程对象
        Course course = courseService.getById(courseid);

        model.addAttribute("course",course);
        List<CourseComment> courseCommentList = courseCommentService.getBycourseId(courseid);
        model.addAttribute("courseCommentList",courseCommentList);
        return "course_comment";
    }

    @ResponseBody
    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            courseService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }

        return baseResult;
    }

    @ResponseBody
    @RequestMapping(value = "/commentdelete" ,method = RequestMethod.POST)
    public BaseResult Commentdelete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            courseCommentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }

        return baseResult;
    }
}
