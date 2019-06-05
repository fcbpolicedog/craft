package com.policedog.craftadmin.domain;

/**
 * 课程统计图表对象
 */
public class CourseCharts {
    private Long id;
    //课程ID
    private Long courseid;
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

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
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

    @Override
    public String toString() {
        return "CourseCharts{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", clicks=" + clicks +
                ", totaltime=" + totaltime +
                '}';
    }
}
