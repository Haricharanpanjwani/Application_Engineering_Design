package com.spring.forensic.velocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineFactory;

@Component
public class Mailer {
	
	private MailSender mailSender;
	private VelocityEngine velocityEngine;

	 public void setMailSender(MailSender mailSender) {
		 this.mailSender = mailSender;
	 }

	 public void setVelocityEngine(VelocityEngine velocityEngine) {
	  this.velocityEngine = velocityEngine;
	 }

	 public void sendMail(Mail mail) {
		 
		 VelocityEngineFactory factory = new VelocityEngineFactory();
		 
		  SimpleMailMessage message = new SimpleMailMessage();
		  
		  message.setFrom(mail.getMailFrom());
		  message.setTo(mail.getMailTo());
		  message.setSubject(mail.getMailSubject());
	
		 Template template = velocityEngine.getTemplate("./views/" + mail.getTemplateName());
		 System.out.println("template: " + template);
	
		  VelocityContext velocityContext = new VelocityContext();
		  velocityContext.put("firstName", "Yashwant");
		  velocityContext.put("lastName", "Chavan");
		  velocityContext.put("location", "Pune");
		  
		  StringWriter stringWriter = new StringWriter();
		  
		 template.merge(velocityContext, stringWriter);
		  
		  message.setText(stringWriter.toString());
		  
		  mailSender.send(message);
	 }

}
