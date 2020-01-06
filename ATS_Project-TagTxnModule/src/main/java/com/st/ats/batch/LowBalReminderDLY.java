
package com.st.ats.batch;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.ats.batch.Constants.BatchConstants;
import com.st.ats.batch.helper.LowBalReminderDLYHelper;
import com.st.ats.entity.BatchRunDtlsEntity;
import com.st.ats.entity.BatchRunSummaryEntity;
import com.st.ats.entity.TagTxnTriggerEntity;
import com.st.ats.entity.UserMasterEntity;
import com.st.ats.reporitory.BatchRunDtlsRepo;
import com.st.ats.reporitory.BatchRunSummaryRepo;
import com.st.ats.reporitory.TagMasterRepository;
import com.st.ats.reporitory.TagTxnTriggerRepository;
import com.st.ats.reporitory.UserMasterRepository;

/**
 * This batch class is used to send email and message to user whose tag balance
 * is going in negative or low balance
 * 
 * @author SAUMYA
 *
 */
@Component
public class LowBalReminderDLY implements Batch {

	@Autowired
	private BatchRunDtlsRepo batchRunDtlsRepo;
	@Autowired
	private BatchRunSummaryRepo batchRunSummaryRepo;
	@Autowired
	private TagTxnTriggerRepository tagTxnTriggerRepository;
	@Autowired
	private TagMasterRepository tagMasterRepository;
	@Autowired
	private UserMasterRepository userRepository;
	@Autowired
	private LowBalReminderDLYHelper helper;

	private static Integer SUCC_CNT = 0;
	private static Integer FAIL_CNT = 0;
	private static Integer TOTAL_CNT = 0;

	private static Long trigId = null;

	@Override
	public Long preProcess() {
		if (trigId == null) {
			BatchRunDtlsEntity dtlsEntity = new BatchRunDtlsEntity();
			dtlsEntity.setBatchName(BatchConstants.LOW_BAL_BATCH_NAME);
			dtlsEntity.setCreateBy(BatchConstants.LOW_BAL_BATCH_NAME);
			dtlsEntity.setStartDt(new Date());
			dtlsEntity.setRunStatus("ST");
			BatchRunDtlsEntity batchDtlsEntity = batchRunDtlsRepo.save(dtlsEntity);
			trigId = batchDtlsEntity.getRunId();
		}
		return trigId;
	}

	@Override
	public void start() {
		List<TagTxnTriggerEntity>  failTxnTriggerEntities = tagTxnTriggerRepository.findFailureRecords(BatchConstants.FAILD_STATUS, BatchConstants.FAIL_RSN,
				BatchConstants.REM_MSG_SW);
		TOTAL_CNT = failTxnTriggerEntities.size();
		ExecutorService exService=Executors.newFixedThreadPool(20);
		CompletionService pool=new ExecutorCompletionService(exService);
		
		failTxnTriggerEntities.forEach(failEntity->
		poll.submit(new Callable<Object>() {
			public Object call() {
		
			Long txnId=failEntity.getTrgId();
			Long tagId=failEntity.getTagId();
			 Long userId = tagMasterRepository.findUserId(tagId);
			 Optional<UserMasterEntity> userInfo = userRepository.findById(userId);
			 if(userInfo.isPresent()) {
				 UserMasterEntity userEntity = userInfo.get();
				 process(userEntity.getEmail(),userEntity.getPhno(),txnId,userEntity.getFname(),userEntity.getLname());
				 System.out.println("One Record  is Executed");
			 }
			}
			});

	@Override
	public void process(String email, Long phno, Long trgId, String fname, String lname) {
		try {
			helper.sendMessage(phno);
			helper.sendMail(email, fname, lname);
			tagTxnTriggerRepository.updatetriggerAsCompleted(trgId, BatchConstants.LOW_BAL_BATCH_NAME);
			SUCC_CNT++;
		} catch (Exception e) {
			e.printStackTrace();
			FAIL_CNT++;
		}
	}

	@Override
	public void postProcess() {
		System.out.println("post process method called");
		Long batchRunDtlsId = this.preProcess();

		BatchRunSummaryEntity summaryEntity = new BatchRunSummaryEntity();
		String msg = "TOT_CNT= " + TOTAL_CNT + ", SUCC_CNT= " + SUCC_CNT + ", FAIL_CNT= " + FAIL_CNT;

		summaryEntity.setBatchName(BatchConstants.LOW_BAL_BATCH_NAME);
		summaryEntity.setSummaryDtls(msg);
		summaryEntity.setCreateBy(BatchConstants.LOW_BAL_BATCH_NAME);
		summaryEntity.setUpdateBy(BatchConstants.LOW_BAL_BATCH_NAME);

		batchRunSummaryRepo.save(summaryEntity);
		helper.updateBatchDtls(batchRunDtlsId);
	}

	public void test() {
		this.preProcess();
		this.start();
		this.postProcess();
	}

}