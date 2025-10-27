package com.example.Scholarship_matcher.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Scholarship_matcher.model.Scholarship;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {}

