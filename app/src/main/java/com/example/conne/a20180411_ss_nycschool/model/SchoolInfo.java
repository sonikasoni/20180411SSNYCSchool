package com.example.conne.a20180411_ss_nycschool.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SchoolInfo implements Serializable {

    @SerializedName("DBN")
    private String dbn;

    @SerializedName("SCHOOL NAME")
    private String schoolName;

    @SerializedName("Num of SAT Test Takers")
    private String numOfSatTestTakers;

    @SerializedName("SAT Critical Reading Avg. Score")
    private String satCriticalReadingAvgScore;

    @SerializedName("SAT Math Avg. Score")
    private String satMathAvgScore;

    @SerializedName("SAT Writing Avg. Score")
    private String satWritingAvgScore;

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

    public String getNumOfSatTestTakers() {
        return numOfSatTestTakers;
    }

    public void setNumOfSatTestTakers(String numOfSatTestTakers) {
        this.numOfSatTestTakers = numOfSatTestTakers;
    }

    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    public void setSatCriticalReadingAvgScore(String satCriticalReadingAvgScore) {
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }

    public void setSatWritingAvgScore(String satWritingAvgScore) {
        this.satWritingAvgScore = satWritingAvgScore;
    }
}
