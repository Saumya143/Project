package com.ats.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.entity.BatchRunSummaryEntity;

public interface BatchRunSummeryRepositary extends JpaRepository<BatchRunSummaryEntity, Integer>{

}
