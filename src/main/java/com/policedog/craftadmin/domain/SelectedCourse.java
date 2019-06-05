package com.policedog.craftadmin.domain;

public class SelectedCourse {
    private Long crouseid;
    private Long studentid;
    private Integer mark;

    public Long getCrouseid() {
        return crouseid;
    }

    public void setCrouseid(Long crouseid) {
        this.crouseid = crouseid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SelectedCourse{" +
                "crouseid=" + crouseid +
                ", studentid=" + studentid +
                ", mark=" + mark +
                '}';
    }
}
