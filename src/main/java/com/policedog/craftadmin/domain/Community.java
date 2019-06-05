package com.policedog.craftadmin.domain;

import java.util.Date;

public class Community {
    private Long id;
    private Integer isStudent;//1-->学生 0-->教师

    private Long userid;//发帖的用户ID

    private Integer isQuestion;//1-->提问 0-->回帖

    private Long fatherid;//回帖的主帖ID

    private String content; //帖子内容

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Integer isStudent) {
        this.isStudent = isStudent;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getIsQuestion() {
        return isQuestion;
    }

    public void setIsQuestion(Integer isQuestion) {
        this.isQuestion = isQuestion;
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", isStudent=" + isStudent +
                ", userid=" + userid +
                ", isQuestion=" + isQuestion +
                ", fatherid=" + fatherid +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
