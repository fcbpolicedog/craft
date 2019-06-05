package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.commons.RegexpUtils;
import com.policedog.craftadmin.dao.TeacherDAO;
import com.policedog.craftadmin.domain.Teacher;
import com.policedog.craftadmin.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public List<Teacher> selectAll() {
        return teacherDAO.selectAll();
    }

    @Override
    public BaseResult save(Teacher teacher) {
        BaseResult baseResult = checkTbUser(teacher);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //成功
            teacher.setUpdated(new Date());
            if (teacher.getId()==null){
                //新增用户
                teacher.setPassword(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()));
                teacher.setCreated(new Date());
                teacherDAO.insert(teacher);
            }else{
                //update用户
                teacherDAO.update(teacher);
            }

            baseResult.setMessage("保存教师信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(Long id) {
        teacherDAO.delete(id);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherDAO.getById(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDAO.update(teacher);
    }

    @Override
    public List<Teacher> selectByUsername(String username) {
        return teacherDAO.selectByUsername(username);
    }

    @Override
    public List<Teacher> search(String keyword) {
        Teacher teacher = new Teacher();
        teacher.setUsername(keyword);
        teacher.setEmail(keyword);
        teacher.setPhone(keyword);
        return teacherDAO.search(teacher);
    }

    @Override
    public void deleteMulti(String[] ids) {
        teacherDAO.deleteMulti(ids);
    }

    private BaseResult checkTbUser(Teacher teacher){
        BaseResult baseResult = BaseResult.success();
        //非空验证

        if (StringUtils.isBlank(teacher.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        }
        else if (!RegexpUtils.checkEmail(teacher.getEmail())){
            baseResult = BaseResult.fail("邮箱格式错误，请重新输入");
        }
        else if (StringUtils.isBlank(teacher.getPassword())){
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(teacher.getUsername())){
            baseResult = BaseResult.fail("用户名不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(teacher.getPhone())){
            baseResult = BaseResult.fail("手机号不能为空，请重新输入");
        }
        else if (!RegexpUtils.checkPhone(teacher.getPhone())){
            baseResult = BaseResult.fail("手机号格式错误，请重新输入");
        }

        return baseResult;
    }
}
