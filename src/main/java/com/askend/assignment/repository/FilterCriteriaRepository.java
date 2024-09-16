package com.askend.assignment.repository;

import com.askend.assignment.model.FilterCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterCriteriaRepository extends JpaRepository<FilterCriteria, Long> {
}