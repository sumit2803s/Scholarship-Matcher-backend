package com.example.Scholarship_matcher.service;


import com.example.Scholarship_matcher.model.Scholarship;
import com.example.Scholarship_matcher.model.UserProfile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MatchingAlgorithm {

    public boolean isEligible(UserProfile user, Scholarship s) {
        boolean eligible = true;
        if (s.getMinGpa() != null && user.getGpa() < s.getMinGpa()) eligible = false;
        if (s.getFinancialNeed() && !user.getFinancialNeed()) eligible = false;
        System.out.println("Checking " + s.getTitle() + ": eligible=" + eligible);
        return eligible;
    }

    public double calculateMatchScore(UserProfile user, Scholarship s) {
        double prog = s.getProgramType().equalsIgnoreCase(user.getProgramType()) ? 1.0 : 0.5;
        double gpaScore = (user.getGpa() / 4.0);
        double need = (s.getFinancialNeed().equals(user.getFinancialNeed())) ? 1.0 : 0.5;
        double kw = 0.0;

        if (user.getKeywords() != null && s.getKeywords() != null) {
            long matches = Arrays.stream(user.getKeywords())
                    .filter(k -> s.getKeywords().toLowerCase().contains(k.toLowerCase()))
                    .count();
            kw = Math.min(1.0, (double) matches / 3);
        }

        return (0.3 * prog + 0.25 * gpaScore + 0.15 * need + 0.2 * kw + 0.1 * (s.getBaseMatchScore() != null ? s.getBaseMatchScore() : 0.5));
    }

}

