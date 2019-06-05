package com.policedog.craftadmin.service;

import com.policedog.craftadmin.domain.Admin;

import java.util.List;

public interface AdminService {

    Admin login(String email,String password);
}
