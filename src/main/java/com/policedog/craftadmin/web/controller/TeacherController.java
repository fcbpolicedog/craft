package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Teacher;
import com.policedog.craftadmin.service.CourseService;
import com.policedog.craftadmin.service.TeacherService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @ModelAttribute
    public Teacher getTeacher(Long id){
        Teacher teacher = null;
        //id不为空，则从数据库获取
        if (id!=null){
            teacher = teacherService.getById(id);
        }else {
            teacher = new Teacher();
        }
        return teacher;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<Teacher> teacherList = teacherService.selectAll();
        model.addAttribute("teacherList",teacherList);
        return "teacher_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "teacher_form";
    }


    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Teacher teacher, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = teacherService.save(teacher);

        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/teacher/test";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "teacher_form";
        }
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(String keyword,Model model){
        List<Teacher> teacherList = teacherService.search(keyword);
        model.addAttribute("teacherList",teacherList);
        return "teacher_list";
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(Model model){
        List<Teacher> teacherList = teacherService.selectAll();
        model.addAttribute("teacherList",teacherList);
        return "teacher_test";
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(Model model, HttpServletRequest request){
        Long teacherid = Long.valueOf(request.getParameter("id"));
        Teacher teacher = teacherService.getById(teacherid);
        model.addAttribute("teacher",teacher);

        List<CourseVO> courseVOList = courseService.getByTeacherId(teacherid);
        model.addAttribute("courseVOList",courseVOList);
        return "teacher_detail";
    }
    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            teacherService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
