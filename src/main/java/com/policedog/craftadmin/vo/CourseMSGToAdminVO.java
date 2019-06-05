package com.policedog.craftadmin.vo;

import java.util.Date;

public class CourseMSGToAdminVO {
    //课程更新消息编号
    private Long id;
    //课程编号
    private Long courseid;
    //消息状态 0-->未处理，1-->已处理
    private String status;
    //更新时间
    private Date courseupdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCourseupdate() {
        return courseupdate;
    }

    public void setCourseupdate(Date courseupdate) {
        this.courseupdate = courseupdate;
    }

    @Override
    public String toString() {
        return "CourseMSGToAdminVO{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", status='" + status + '\'' +
                ", courseupdate=" + courseupdate +
                '}';
    }
}
