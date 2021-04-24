package lk.sliit.PAF.project.dto;

public class ProjectDTO {
    private int projectID;
    private String publisherName;
    private String projectName;
    private String email;
    private String status;
    private String link;
    private String updatedDate;
    private String submittedDate;
    private String description;

    public ProjectDTO() {
    }

    public ProjectDTO(int id) {
        this.projectID = id;
    }

    public ProjectDTO(int projectID, String publisherName, String projectName, String email, String status, String link, String updatedDate, String submittedDate, String description) {
        this.projectID = projectID;
        this.publisherName = publisherName;
        this.projectName = projectName;
        this.email = email;
        this.status = status;
        this.link = link;
        this.updatedDate = updatedDate;
        this.submittedDate = submittedDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectID=" + projectID +
                ", publisherName='" + publisherName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", link='" + link + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", submittedDate='" + submittedDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + projectID;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProjectDTO other = (ProjectDTO) obj;
        if (projectID != other.projectID)
            return false;
        return true;
    }
}

