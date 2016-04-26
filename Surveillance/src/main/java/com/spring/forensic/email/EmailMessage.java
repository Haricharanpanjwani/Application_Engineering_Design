package com.spring.forensic.email;

import org.springframework.stereotype.Component;

@Component
public class EmailMessage {


    private String receiverEmailAddress;
    private String subject;
    private String messageBody;


    public void setMessageBody(String messageBody){

        this.messageBody=messageBody;
    }

    public String getMessageBody(){

        return this.messageBody;
    }

    public void setReceiverEmailAddress(String receiverEmailAddress){

        this.receiverEmailAddress=receiverEmailAddress;
    }

    public String getReceiverEmailAddress(){

        return this.receiverEmailAddress;
    }


    public void setSubject(String subject) {

        this.subject=subject;
    }

    public String getSubject(){

        return this.subject;
    }


}
