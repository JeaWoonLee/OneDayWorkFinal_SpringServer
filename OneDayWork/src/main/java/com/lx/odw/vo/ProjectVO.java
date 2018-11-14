package com.lx.odw.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProjectVO {


    int projectNumber;
    String projectName;
    String offerId;
    String projectStartDate;
    String projectEndDate;
    double projectLat;
    double projectLng;
    String projectComment;
    String projectSubject;
    String projectEnrollDate;
    String workStartTime;
    String workEndTime;
    int requestPicture;
    

    public int getProjectNumber () {
        return projectNumber;
    }

    public void setProjectNumber (int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName () {
        return projectName;
    }

    public void setProjectName (String projectName) {
        this.projectName = projectName;
    }

    public String getOfferId () {
        return offerId;
    }

    public void setOfferId (String offerId) {
        this.offerId = offerId;
    }

    public String getProjectStartDate () {
        return projectStartDate;
    }

    public void setProjectStartDate (String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectEndDate () {
        return projectEndDate;
    }

    public void setProjectEndDate (String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public double getProjectLat () {
        return projectLat;
    }

    public void setProjectLat (double projectLat) {
        this.projectLat = projectLat;
    }

    public double getProjectLng () {
        return projectLng;
    }

    public void setProjectLng (double projectLng) {
        this.projectLng = projectLng;
    }

    public String getProjectComment () {
        return projectComment;
    }

    public void setProjectComment (String projectComment) {
        this.projectComment = projectComment;
    }

    public String getProjectSubject () {
        return projectSubject;
    }

    public void setProjectSubject (String projectSubject) {
        this.projectSubject = projectSubject;
    }

    public String getProjectEnrollDate () {
        return projectEnrollDate;
    }

    public void setProjectEnrollDate (String projectEnrollDate) {
        this.projectEnrollDate = projectEnrollDate;
    }

    
    public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public int getRequestPicture() {
		return requestPicture;
	}

	public void setRequestPicture(int requestPicture) {
		this.requestPicture = requestPicture;
	}

	@Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
