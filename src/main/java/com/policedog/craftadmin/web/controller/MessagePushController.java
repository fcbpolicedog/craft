package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.domain.CourseMSGToAdmin;
import com.policedog.craftadmin.domain.CourseMSGToStudent;
import com.policedog.craftadmin.service.CourseMSGToAdminService;
import com.policedog.craftadmin.service.CourseMSGToStudentService;
import com.policedog.craftadmin.vo.CourseMSGToAdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessagePushController {

    @Autowired
    private CourseMSGToAdminService courseMSGToAdminService;

    @Autowired
    private CourseMSGToStudentService courseMSGToStudentService;

    @ModelAttribute
    public CourseMSGToAdmin getCourseMSGToAdmin(Long id){
        CourseMSGToAdmin courseMSGToAdmin = null;
        //id不为空，则从数据库获取
        if (id!=null){
            courseMSGToAdmin = courseMSGToAdminService.getById(id);
        }else {
            courseMSGToAdmin = new CourseMSGToAdmin();
        }
        return courseMSGToAdmin;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String selectCourseMSG(Model model){
        List<CourseMSGToAdminVO> courseMSGToAdminVOList = courseMSGToAdminService.selectAll();
        model.addAttribute("courseMSGToAdminVOList",courseMSGToAdminVOList);
        return "messageToAdmin_list";
    }

    @RequestMapping(value = "/push",method = RequestMethod.GET)
    public String pushMessage(Model model, HttpServletRequest request){
        Long messageid = Long.valueOf(request.getParameter("id"));
        //先更新发送给管理员的消息状态
        CourseMSGToAdmin courseMSGToAdmin = courseMSGToAdminService.getById(messageid);
        courseMSGToAdmin.setStatus(1);
        courseMSGToAdminService.update(courseMSGToAdmin);
        //处理发送推送消息给用户的逻辑
        //首先获取courseId对应的用户列表
        List<Long> studentIdlist = courseMSGToStudentService.selectStudentIdByCourseId(courseMSGToAdmin.getCourseid());
        //依次处理消息，存储消息到数据库中
        for (Long studentId: studentIdlist) {
            CourseMSGToStudent courseMSGToStudent = new CourseMSGToStudent();
            courseMSGToStudent.setReciverid(studentId);
            courseMSGToStudent.setContent("您参与的课程有更新，请前往课程主页查看，课程号："+courseMSGToAdmin.getCourseid());
            courseMSGToStudent.setCreated(new Date());
            courseMSGToStudentService.insert(courseMSGToStudent);
        }
        List<CourseMSGToAdminVO> courseMSGToAdminVOList = courseMSGToAdminService.selectAll();
        model.addAttribute("courseMSGToAdminVOList",courseMSGToAdminVOList);
        return "redirect:/message/list";
    }

}