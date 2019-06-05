package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.commons.RegexpUtils;
import com.policedog.craftadmin.dao.StudentDAO;
import com.policedog.craftadmin.domain.Student;
import com.policedog.craftadmin.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;
    @Override
    public List<Student> selectAll() {
        return studentDAO.selectAll();
    }

    @Override
    public BaseResult save(Student student) {
        BaseResult baseResult = checkTbUser(student);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //成功
            student.setUpdated(new Date());
            if (student.getId()==null){
                //新增用户
                student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
                student.setCreated(new Date());
                studentDAO.insert(student);
            }else{
                //update用户
                studentDAO.update(student);
            }

            baseResult.setMessage("保存学生信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Student getById(Long id) {
        return studentDAO.getById(id);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public List<Student> selectByUsername(String username) {
        return selectByUsername(username);
    }


    //模糊查询
    @Override
    public List<Student> search(String keyword) {
        Student student = new Student();
        student.setUsername(keyword);
        student.setEmail(keyword);
        student.setPhone(keyword);
        return studentDAO.search(student);
    }

    @Override
    public void deleteMulti(String[] ids) {
        studentDAO.deleteMulti(ids);
    }

    /**
     * 用户有效性验证
     * @param student
     */
    private BaseResult checkTbUser(Student student){
        BaseResult baseResult = BaseResult.success();
        //非空验证

        if (StringUtils.isBlank(student.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        }
        else if (!RegexpUtils.checkEmail(student.getEmail())){
            baseResult = BaseResult.fail("邮箱格式错误，请重新输入");
        }
        else if (StringUtils.isBlank(student.getPassword())){
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(student.getUsername())){
            baseResult = BaseResult.fail("用户名不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(student.getPhone())){
            baseResult = BaseResult.fail("手机号不能为空，请重新输入");
        }
        else if (!RegexpUtils.checkPhone(student.getPhone())){
            baseResult = BaseResult.fail("手机号格式错误，请重新输入");
        }

        return baseResult;
    }

}
