package com.example.Scholarship_matcher.controller;


import com.example.Scholarship_matcher.model.UserProfile;
import com.example.Scholarship_matcher.service.ScholarshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/scholarships")
public class ScholarshipController {

    public ScholarshipController(ScholarshipService service) {
        this.service = service;
    }

    private final ScholarshipService service;

    @PostMapping("/match")
    public Map<String, Object> match(@RequestBody UserProfile profile) {
        List<Map<String, Object>> results = service.matchScholarships(profile);
        Map<String, Object> response = new HashMap<>();
        response.put("count", results.size());
        response.put("results", results);
        return response;
    }

    @GetMapping
    public List<Map<String, Object>> all() {
        return service.matchScholarships(new UserProfile());
    }
}
