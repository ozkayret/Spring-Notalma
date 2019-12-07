package com.oguzkurtcebe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.notalma.HomeController;

@Service
public class MailService {
    @Autowired
	private MailSender mailSender;

	public void registerMail(String mail,String key) {
		SimpleMailMessage email=new SimpleMailMessage();
		
		email.setFrom("aktivasyonhesabi@gmail.com");
		email.setTo(mail);
		email.setSubject("Üyeliði Tamamla");
		email.setText("Üyeliði tamamlamak için Aþaðýdaki linke týklayýnýz.\n\n"
		+HomeController.url+"/reg/"+key);
		mailSender.send(email);
		
	}
}
