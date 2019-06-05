package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.dao.CourseDAO;
import com.policedog.craftadmin.dao.SectionDAO;
import com.policedog.craftadmin.dao.TeacherDAO;
import com.policedog.craftadmin.domain.Course;
import com.policedog.craftadmin.domain.Section;
import com.policedog.craftadmin.domain.Teacher;
import com.policedog.craftadmin.service.CourseService;
import com.policedog.craftadmin.vo.CourseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private SectionDAO sectionDAO;

    public List<CourseVO> transCourseListToCourseVOList(List<Course> courseList){
        List<CourseVO> courseVOList = new ArrayList<>();
        for (Course course: courseList) {
            CourseVO courseVO = new CourseVO();

            courseVO.setId(course.getId());
            courseVO.setCoursename(course.getCoursename());
            courseVO.setCourseinfo(course.getCourseinfo());
            courseVO.setTeacherinfo(course.getTeacherinfo());
            courseVO.setStudentnum(course.getStudentnum());
            courseVO.setCoursetype(course.getCoursetype());
            courseVO.setUpdated(course.getUpdated());
            courseVO.setPic(course.getPic());
            //查教师姓名
            Teacher teacher = teacherDAO.getById(course.getTeacherid());
            courseVO.setTeachername(teacher.getUsername());

            courseVOList.add(courseVO);
        }
        return courseVOList;
    }

    @Override
    public List<CourseVO> selectAll() {
        List<Course> courseList = courseDAO.selectAll();
        return transCourseListToCourseVOList(courseList);
    }
    @Override
    public List<CourseVO> getByTeacherId(Long teacherid) {
        List<Course> courseList = courseDAO.getByTeacherId(teacherid);
        return transCourseListToCourseVOList(courseList);
    }

    @Override
    public void insert(Course course) {
        courseDAO.insert(course);
    }

    @Override
    public void delete(Long id) {
        courseDAO.delete(id);
    }

    @Override
    public void update(Course course) {
        courseDAO.update(course);
    }

    @Override
    public List<CourseVO> search(String keyword) {
        Course course = new Course();
        course.setCoursename(keyword);
        course.setCoursetype(keyword);
        List<Course> courseList = courseDAO.search(course);
        return transCourseListToCourseVOList(courseList);
    }

    @Override
    public void deleteMulti(String[] ids) {
        courseDAO.deleteMulti(ids);
    }

    @Override
    public Course getById(Long id) {
        return courseDAO.getById(id);
    }

    @Override
    public BaseResult save(Course course) {
        BaseResult baseResult = checkTbUser(course);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //成功
            course.setUpdated(new Date());
            if (course.getId()==null){
                //新增用户
                course.setCreated(new Date());
                courseDAO.insert(course);
            }else{
                //update用户
                courseDAO.update(course);
            }

            baseResult.setMessage("保存课程信息成功");
        }
        return baseResult;
    }

    @Override
    public List<Section> getByCourseId(Long courseid) {
        return sectionDAO.getByCourseId(courseid);
    }




    private BaseResult checkTbUser(Course course){
        BaseResult baseResult = BaseResult.success();
        //非空验证

        if (StringUtils.isBlank(course.getCoursename())){
            baseResult = BaseResult.fail("课程名不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(course.getCoursetype())){
            baseResult = BaseResult.fail("课程类型不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(course.getCourseinfo())){
            baseResult = BaseResult.fail("课程信息不能为空，请重新输入");
        }
        else if (StringUtils.isBlank(course.getTeacherinfo())){
            baseResult = BaseResult.fail("教师信息不能为空，请重新输入");
        }
        return baseResult;
    }
}
