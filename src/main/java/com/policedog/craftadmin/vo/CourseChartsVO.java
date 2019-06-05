package com.policedog.craftadmin.vo;

public class CourseChartsVO {
    private Long id;
    //课程ID
    private String coursename;
    //课程总点击数
    private Long clicks;
    //课程总学习时长(以分钟为单位)
    private Long totaltime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(Long totaltime) {
        this.totaltime = totaltime;
    }
}
