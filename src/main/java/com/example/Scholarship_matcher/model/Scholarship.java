package com.example.Scholarship_matcher.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String provider;
    private String programType; // Undergraduate / Graduate / MBA
    private String country;
    private Double minGpa;
    private Boolean financialNeed;
    private Double baseMatchScore;
    private String keywords;
    private Double amountMin;
    private Double amountMax;
    private String deadline;
    private String applyUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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

    public Double getMinGpa() {
        return minGpa;
    }

    public void setMinGpa(Double minGpa) {
        this.minGpa = minGpa;
    }

    public Boolean getFinancialNeed() {
        return financialNeed;
    }

    public void setFinancialNeed(Boolean financialNeed) {
        this.financialNeed = financialNeed;
    }

    public Double getBaseMatchScore() {
        return baseMatchScore;
    }

    public void setBaseMatchScore(Double baseMatchScore) {
        this.baseMatchScore = baseMatchScore;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Double getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(Double amountMin) {
        this.amountMin = amountMin;
    }

    public Double getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(Double amountMax) {
        this.amountMax = amountMax;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getApplyUrl() {
        return applyUrl;
    }

    public void setApplyUrl(String applyUrl) {
        this.applyUrl = applyUrl;
    }
}

