package com.policedog.craftadmin.domain;

import java.util.Date;

//发送给系统管理员的课程更新消息
public class CourseMSGToAdmin {
    //课程更新消息编号
    private Long id;
    //课程编号
    private Long courseid;
    //消息状态 0-->未处理，1-->已处理
    private Integer status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
        return "CourseMSGToAdmin{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", status=" + status +
                ", courseupdate=" + courseupdate +
                '}';
    }
}
