package com.st.ats.reporitory;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.st.ats.entity.BatchRunDtlsEntity;

public interface BatchRunDtlsRepo extends JpaRepository<BatchRunDtlsEntity,Long>{

	@Transactional
	@Modifying
	@Query("update BatchRunDtlsEntity be set be.runStatus=:status,be.endDt=:endDt,be.updatedBy=:updateBy where be.runId=:runId")
	public void updateBatchRunDtlsStatus(String status,Date endDt,String updateBy,Long runId);
}
