package models;

import enums.ProjectType;

public class Project {
    private String name;
    private String newName;
    private String Announcement;
    private boolean isShowAnnouncement;
    private ProjectType projectType;

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return Announcement;
    }

    public void setAnnouncement(String announcement) {
        Announcement = announcement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        isShowAnnouncement = showAnnouncement;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

}