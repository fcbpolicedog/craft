package com.policedog.craftadmin.domain;

import java.util.Date;

public class Course {

    private Long courseid;
    private Long teacherid;
    private String coursename;
    private String coursetype;
    private String courseinfo;
    private String teacherinfo;
    private String pic;
    private Integer studentnum;
    private Date created;
    private Date updated;

    public Long getId() {
        return courseid;
    }

    public void setId(Long courseid) {
        this.courseid = courseid;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getCourseinfo() {
        return courseinfo;
    }

    public void setCourseinfo(String courseinfo) {
        this.courseinfo = courseinfo;
    }

    public String getTeacherinfo() {
        return teacherinfo;
    }

    public void setTeacherinfo(String teacherinfo) {
        this.teacherinfo = teacherinfo;
    }

    public Integer getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(Integer studentnum) {
        this.studentnum = studentnum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", teacherid=" + teacherid +
                ", coursename='" + coursename + '\'' +
                ", coursetype='" + coursetype + '\'' +
                ", courseinfo='" + courseinfo + '\'' +
                ", teacherinfo='" + teacherinfo + '\'' +
                ", studentnum=" + studentnum +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
