package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.ConstantUtils;
import com.policedog.craftadmin.domain.Admin;
import com.policedog.craftadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String email, String password, HttpServletRequest request, Model model){
        Admin admin = adminService.login(email, password);
        if (admin==null){
            model.addAttribute("message","邮箱或密码错误");
            return "login";
        }else{
            //登陆成功
            request.getSession().setAttribute(ConstantUtils.SESSION_USER,admin);
            //return "redirect:main";
            return "redirect:/charts/list";

        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
}
