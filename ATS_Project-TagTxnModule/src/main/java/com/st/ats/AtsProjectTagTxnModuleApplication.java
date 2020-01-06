package com.st.ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.st.ats.batch.LowBalReminderDLY;

@SpringBootApplication
public class AtsProjectTagTxnModuleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(AtsProjectTagTxnModuleApplication.class, args);
		LowBalReminderDLY bean = applicationContext.getBean(LowBalReminderDLY.class);
		bean.test();
		System.out.println("This is success");

	}

}
