package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.dao.CourseMSGToAdminDAO;
import com.policedog.craftadmin.domain.CourseMSGToAdmin;
import com.policedog.craftadmin.service.CourseMSGToAdminService;
import com.policedog.craftadmin.vo.CourseMSGToAdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseMSGToAdminServiceImpl implements CourseMSGToAdminService {
    @Autowired
    private CourseMSGToAdminDAO courseMSGToAdminDAO;

    @Override
    public List<CourseMSGToAdminVO> selectAll() {
        List<CourseMSGToAdmin> courseMSGToAdminList = courseMSGToAdminDAO.selectAll();
        return transCourseMSGToAdminListToVOList(courseMSGToAdminList);
    }

    @Override
    public void insert(CourseMSGToAdmin courseMSGToAdmin) {
        courseMSGToAdminDAO.insert(courseMSGToAdmin);
    }

    @Override
    public CourseMSGToAdmin getById(Long id) {
        return courseMSGToAdminDAO.getById(id);
    }

    @Override
    public List<CourseMSGToAdminVO> search(CourseMSGToAdmin courseMSGToAdmin) {
        List<CourseMSGToAdmin> courseMSGToAdminList = courseMSGToAdminDAO.search(courseMSGToAdmin);
        return transCourseMSGToAdminListToVOList(courseMSGToAdminList);
    }

    @Override
    public void update(CourseMSGToAdmin courseMSGToAdmin) {
        courseMSGToAdminDAO.update(courseMSGToAdmin);
    }

    public List<CourseMSGToAdminVO> transCourseMSGToAdminListToVOList(List<CourseMSGToAdmin> courseMSGToAdminList){
        List<CourseMSGToAdminVO> courseMSGToAdminVOList = new ArrayList<>();
        for (CourseMSGToAdmin courseMSGToAdmin : courseMSGToAdminList){
            CourseMSGToAdminVO courseMSGToAdminVO = new CourseMSGToAdminVO();
            courseMSGToAdminVO.setCourseid(courseMSGToAdmin.getCourseid());
            courseMSGToAdminVO.setId(courseMSGToAdmin.getId());
            courseMSGToAdminVO.setCourseupdate(courseMSGToAdmin.getCourseupdate());
            if (courseMSGToAdmin.getStatus()==0){
                courseMSGToAdminVO.setStatus("未处理");
            }else {
                courseMSGToAdminVO.setStatus("已处理");
            }
            courseMSGToAdminVOList.add(courseMSGToAdminVO);
        }
        return courseMSGToAdminVOList;
    }
}
