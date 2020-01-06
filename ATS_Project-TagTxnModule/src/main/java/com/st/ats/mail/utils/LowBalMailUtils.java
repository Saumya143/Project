package com.st.ats.mail.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.st.ats.batch.Constants.MailConstants;

/**
 * This class is used to send to mail  load the template and replace the place holder and 
 * and set original value and   Send mail to users
 * 
 * @author SAUMYA
 *
 */
@Component
public class LowBalMailUtils {

	@Autowired
	private JavaMailSender sender;

	public Boolean sendMail(String email, String fname, String lname) {
		
		Boolean flag = false;
		String template = "";
		try {
			ClassPathResource fileReader = new ClassPathResource(MailConstants.LOWBL_REM_EMAIL_TEMPLATE_FILE);
			File file = fileReader.getFile();
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
				if (bufferedReader != null) {
					while (bufferedReader.ready()) {
						template = template + bufferedReader.readLine();
					}
					if (template != null && !template.equals("")) {
						template = template.replace(MailConstants.FNAME_PHOLDER, fname);
						template = template.replace(MailConstants.LNAME_PHOLDER, lname);
					}
				}
			}
			try {
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, !flag);
				helper.setTo(email);
				helper.setSubject(MailConstants.SUBJECT_FOR_LOW_BAL_MAIL);
				helper.setText(template, true);
				helper.addInline("logoImage", new File("src\\main\\resources\\static\\images\\atslogo.png"));
				sender.send(message);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
