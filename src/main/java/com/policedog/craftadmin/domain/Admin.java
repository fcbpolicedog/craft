package com.policedog.craftadmin.domain;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate() {
        return created;
    }

    public void setCreate(Date created) {
        this.created = created;
    }

    public Date getUpdate() {
        return updated;
    }

    public void setUpdate(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", create=" + created +
                ", update=" + updated +
                '}';
    }
}
