package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.CourseMSGToAdmin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMSGToAdminDAO {

    List<CourseMSGToAdmin> selectAll();

    void insert(CourseMSGToAdmin courseMSGToAdmin);

    CourseMSGToAdmin getById(Long id);

    List<CourseMSGToAdmin> search(CourseMSGToAdmin courseMSGToAdmin);

    void update(CourseMSGToAdmin courseMSGToAdmin);
}
