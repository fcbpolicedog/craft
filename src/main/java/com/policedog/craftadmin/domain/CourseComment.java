package com.policedog.craftadmin.domain;

public class CourseComment {
    private Long id;
    private Long courseid;
    private Long studentid;
    private String comment;

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

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "coursecomment{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", studentid=" + studentid +
                ", comment='" + comment + '\'' +
                '}';
    }
}
