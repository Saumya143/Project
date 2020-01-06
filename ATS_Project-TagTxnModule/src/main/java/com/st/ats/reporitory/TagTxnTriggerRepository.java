package com.st.ats.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.st.ats.entity.TagTxnTriggerEntity;

public interface TagTxnTriggerRepository extends JpaRepository<TagTxnTriggerEntity, Long> {

	@Query("from  TagTxnTriggerEntity where txStatus=:status and txFailureRsn=:failRsn and remMsgSwitch=:sw")
	public List<TagTxnTriggerEntity> findFailureRecords(String status,String failRsn,String sw); 
	
	
	@Modifying
	@Transactional
	@Query("update TagTxnTriggerEntity set remMsgSwitch='C',updateBy=:updateBy where trgId=:trgId ")
	public void updatetriggerAsCompleted(Long trgId,String updateBy);
	
	
}
