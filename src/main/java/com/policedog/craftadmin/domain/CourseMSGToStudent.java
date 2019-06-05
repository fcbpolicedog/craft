package com.policedog.craftadmin.domain;

import java.util.Date;

public class CourseMSGToStudent {
    private Long id;
    private Long reciverid;
    private String content;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReciverid() {
        return reciverid;
    }

    public void setReciverid(Long reciverid) {
        this.reciverid = reciverid;
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

    @Override
    public String toString() {
        return "CourseMSGToStudent{" +
                "id=" + id +
                ", reciverid=" + reciverid +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}
