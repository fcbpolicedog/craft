package com.policedog.craftadmin.service;

import com.policedog.craftadmin.domain.CourseMSGToAdmin;
import com.policedog.craftadmin.vo.CourseMSGToAdminVO;

import java.util.List;

public interface CourseMSGToAdminService {

    List<CourseMSGToAdminVO> selectAll();

    void insert(CourseMSGToAdmin courseMSGToAdmin);

    CourseMSGToAdmin getById(Long id);

    List<CourseMSGToAdminVO> search(CourseMSGToAdmin courseMSGToAdmin);

    void update(CourseMSGToAdmin courseMSGToAdmin);
}
