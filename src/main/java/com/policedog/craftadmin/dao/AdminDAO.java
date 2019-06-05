package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDAO {

    /**
     * 查询全部用户信息
     * @return
     */
    List<Admin> selectAll();

    void insert(Admin admin);

    void delete(Long id);

    Admin getById(Long id);

    void update(Admin admin);

    List<Admin> selectByUsername(String username);


    Admin getByEmail(String email);

    List<Admin> search(Admin admin);

    void deleteMulti(String[] ids);


}
