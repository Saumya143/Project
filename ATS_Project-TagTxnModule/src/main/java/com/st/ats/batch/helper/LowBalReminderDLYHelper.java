package com.st.ats.batch.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.ats.batch.Constants.BatchConstants;
import com.st.ats.mail.utils.LowBalMailUtils;
import com.st.ats.reporitory.BatchRunDtlsRepo;

@Service
public class LowBalReminderDLYHelper {

	@Autowired
	private BatchRunDtlsRepo batchRunDtlRepo;
	
	@Autowired
	private LowBalMailUtils balMailUtils;
	
	public void sendMessage(Long phno) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMail(String  email,String fname,String lname) {
			//balMailUtils.sendMail(email, fname, lname);	
           
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBatchDtls(Long batchRunId) {
		batchRunDtlRepo.updateBatchRunDtlsStatus("EN", new Date(), BatchConstants.LOW_BAL_BATCH_NAME, batchRunId);
	}
}
