package com.example.conne.a20180411_ss_nycschool.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class School implements Serializable {
    @SerializedName("dbn")
    private String dbn;

    @SerializedName("school_name")
    private String schoolName;

    @SerializedName("boro")
    private String boro;

    @SerializedName("overview_paragraph")
    private String overviewParagraph;

    @SerializedName("school_10th_seats")
    private String school10thSeats;

    @SerializedName("academicopportunities1")
    private String academicOpportunities1;

    @SerializedName("academicopportunities2")
    private String academicOpportunities2;

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }

    public String getSchool10thSeats() {
        return school10thSeats;
    }

    public void setSchool10thSeats(String school10thSeats) {
        this.school10thSeats = school10thSeats;
    }

    public String getAcademicOpportunities1() {
        return academicOpportunities1;
    }

    public void setAcademicOpportunities1(String academicOpportunities1) {
        this.academicOpportunities1 = academicOpportunities1;
    }

    public String getAcademicOpportunities2() {
        return academicOpportunities2;
    }

    public void setAcademicOpportunities2(String academicOpportunities2) {
        this.academicOpportunities2 = academicOpportunities2;
    }

}
