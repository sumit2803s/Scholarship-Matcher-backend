package com.example.Scholarship_matcher.model;


import lombok.Data;

@Data
public class UserProfile {
    private Double gpa;
    private String programType;
    private String country;
    private Boolean financialNeed;
    private String[] keywords;

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getFinancialNeed() {
        return financialNeed;
    }

    public void setFinancialNeed(Boolean financialNeed) {
        this.financialNeed = financialNeed;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

}

