package com.st.ats.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.ats.entity.BatchRunSummaryEntity;

public interface BatchRunSummaryRepo extends JpaRepository<BatchRunSummaryEntity, Long>{

}
