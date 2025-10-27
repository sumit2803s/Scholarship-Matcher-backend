package com.example.Scholarship_matcher.service;

import com.example.Scholarship_matcher.model.Scholarship;
import com.example.Scholarship_matcher.model.UserProfile;
import com.example.Scholarship_matcher.repository.ScholarshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScholarshipService {

    private final ScholarshipRepository repository;
    private final MatchingAlgorithm algorithm;

    public ScholarshipService(ScholarshipRepository repository, MatchingAlgorithm algorithm) {
        this.repository = repository;
        this.algorithm = algorithm;
    }

    public List<Map<String, Object>> matchScholarships(UserProfile profile) {
        List<Scholarship> all = repository.findAll();

        System.out.println("Total scholarships in DB: " + all.size());

        List<Map<String, Object>> results = all.stream()
                .filter(s -> {
                    boolean eligible = algorithm.isEligible(profile, s);
                    System.out.println("Checking scholarship: " + s.getTitle()
                            + " | GPA required: " + s.getMinGpa()
                            + " | Financial need: " + s.getFinancialNeed()
                            + " | Eligible: " + eligible);
                    return eligible;
                })
                .map(s -> {
                    double score = algorithm.calculateMatchScore(profile, s);
                    Map<String, Object> result = new HashMap<>();
                    result.put("id", s.getId());
                    result.put("title", s.getTitle());
                    result.put("provider", s.getProvider());
                    result.put("score",score * 100);
                    result.put("applyUrl", s.getApplyUrl());

                    result.put("amountMin", s.getAmountMin() != null ? s.getAmountMin().doubleValue() : null);
                    result.put("amountMax", s.getAmountMax() != null ? s.getAmountMax().doubleValue() : null);
                    return result;
                })
                .sorted((a, b) -> Double.compare((Double) b.get("score"), (Double) a.get("score")))
                .limit(20)
                .collect(Collectors.toList());

        System.out.println("Total matched scholarships: " + results.size());
        return results;
    }
}