package com.policedog.craftadmin.domain;

import java.util.Date;

public class Section {
    private Long id;
    private Long courseid;
    private String title;
    private String sectionid;
    private Date created;
    private Date updated;
    private String sectiondate;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSectionid() {
        return sectionid;
    }

    public void setSectionid(String sectionid) {
        this.sectionid = sectionid;
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

    public String getSectiondate() {
        return sectiondate;
    }

    public void setSectiondate(String sectiondate) {
        this.sectiondate = sectiondate;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", title='" + title + '\'' +
                ", sectionid='" + sectionid + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", sectiondate='" + sectiondate + '\'' +
                '}';
    }
}
