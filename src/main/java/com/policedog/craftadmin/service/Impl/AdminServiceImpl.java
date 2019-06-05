package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.dao.AdminDAO;
import com.policedog.craftadmin.domain.Admin;
import com.policedog.craftadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin login(String email, String password) {
        Admin admin = adminDAO.getByEmail(email);
        if (admin!=null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(admin.getPassword())){
                //密码匹配成功
                return admin;
            }
        }
        return null;
    }
}
