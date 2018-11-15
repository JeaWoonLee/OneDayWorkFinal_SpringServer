package com.lx.odw.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WorkVO {

    String projectName;
    String projectSubject;
    double projectLatitude;
    double projectLongitude;
    String projectComment;

    String jobName;
    String jobPay;
    int candidateStatus;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectSubject() {
        return projectSubject;
    }

    public void setProjectSubject(String projectSubject) {
        this.projectSubject = projectSubject;
    }

    public double getProjectLatitude() {
        return projectLatitude;
    }

    public void setProjectLatitude(double projectLatitude) {
        this.projectLatitude = projectLatitude;
    }

    public double getProjectLongitude() {
        return projectLongitude;
    }

    public void setProjectLongitude(double projectLongitude) {
        this.projectLongitude = projectLongitude;
    }

    public String getProjectComment() {
        return projectComment;
    }

    public void setProjectComment(String projectComment) {
        this.projectComment = projectComment;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobPay() {
        return jobPay;
    }

    public void setJobPay(String jobPay) {
        this.jobPay = jobPay;
    }

    public int getCandidateStatus() {
        return candidateStatus;
    }

    public void setCandidateStatus(int candidateStatus) {
        this.candidateStatus = candidateStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }
}
