package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("smsService")
public class SMSService implements MessageService{

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben sms servisiyim, size bir mesaj gönderiyorum : "+message.getMessage());
    }
}
