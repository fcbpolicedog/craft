package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.dao.SelectedCourseDAO;
import com.policedog.craftadmin.domain.Student;
import com.policedog.craftadmin.service.ArticleService;
import com.policedog.craftadmin.service.CourseCommentService;
import com.policedog.craftadmin.service.CourseMSGToStudentService;
import com.policedog.craftadmin.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseCommentService courseCommentService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CourseMSGToStudentService courseMSGToStudentService;

    @Autowired
    private SelectedCourseDAO selectedCourseDAO;
    @ModelAttribute
    public Student getStudent(Long id){
        Student student = null;
        //id不为空，则从数据库获取
        if (id!=null){
            student = studentService.getById(id);
        }else {
            student = new Student();
        }
        return student;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<Student> studentList = studentService.selectAll();
        model.addAttribute("studentList",studentList);
        return "student_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "student_form";
    }


    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Student student, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = studentService.save(student);
        System.out.println(student.toString());
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/student/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "student_form";
        }
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(String keyword,Model model){
        List<Student> studentList = studentService.search(keyword);
        model.addAttribute("studentList",studentList);
        return "student_list";
    }

    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            //外键关系先删除该Id关联的评论信息
            articleService.deleteMultiByStudentId(idArray);
            courseCommentService.deleteMulti(idArray);
            courseMSGToStudentService.deleteMultiByReciverId(idArray);
            selectedCourseDAO.deleteMultiByStudentId(idArray);
            //再删除学生信息
            studentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
//    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
//    public String delete(String ids,Model model,RedirectAttributes redirectAttributes) {
//        BaseResult baseResult = null;
//        if (StringUtils.isNotBlank(ids)) {
//            String[] idArray = ids.split(",");
//            studentService.deleteMulti(idArray);
//            baseResult = BaseResult.success("所选学生信息删除成功");
//            if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
//                redirectAttributes.addFlashAttribute("baseResult", baseResult);
//            }
//            return "redirect:/student/list";
//        }
//        else {
//            baseResult = BaseResult.fail("所选学生信息删除失败");
//            model.addAttribute("baseResult", baseResult);
//            return "/student/list";
//        }
//    }

}
