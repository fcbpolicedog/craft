package com.policedog.craftadmin.web.interceptor;

import com.policedog.craftadmin.commons.ConstantUtils;
import com.policedog.craftadmin.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView!=null&&modelAndView.getViewName()!=null&&modelAndView.getViewName().endsWith("login")){
            Admin user = (Admin) request.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (user!=null) {
                response.sendRedirect("/main");
            }
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
