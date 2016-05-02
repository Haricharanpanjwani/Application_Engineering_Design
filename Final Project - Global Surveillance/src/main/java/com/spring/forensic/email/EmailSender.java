package com.spring.forensic.email;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.velocity.VelocityEngineFactory;

import com.spring.forensic.pojo.UserAccounts;
import com.spring.forensic.pojo.WorkRequests;

public class EmailSender {

    private MailSender mailSender;
    private VelocityEngine velocityEngine;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void setVelocityEngine(VelocityEngine velocityEngine) {
  	  this.velocityEngine = velocityEngine;
  	 }


    public void sendEmail(EmailMessage emailMessage, UserAccounts userAccount, WorkRequests request){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(emailMessage.getReceiverEmailAddress());
        message.setSubject(emailMessage.getSubject());
        message.setText(emailMessage.getMessageBody());
        
        VelocityEngineFactory factory = new VelocityEngineFactory();
        velocityEngine.setProperty("resource.loader", "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        velocityEngine.init();
        
        Template template = velocityEngine.getTemplate("template/emailtemplate.vm");
	
		  VelocityContext velocityContext = new VelocityContext();
		  velocityContext.put("firstName", userAccount.getFirstName());
		  velocityContext.put("lastName", userAccount.getLastName());
		  velocityContext.put("medicine", request.getDrugName());
		  velocityContext.put("quantity", request.getQuantity());
		  
		  StringWriter stringWriter = new StringWriter();
		  
		 template.merge(velocityContext, stringWriter);
		  
		  message.setText(stringWriter.toString());
		  
        //sending the message
        mailSender.send(message);

    }


}
