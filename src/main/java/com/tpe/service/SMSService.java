package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component("smsService")
public class SMSService implements MessageService{

    @Autowired
    private Properties properties;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben sms servisiyim, size bir mesaj gönderiyorum : "+message.getMessage());
        System.out.println("Email : "+properties.get("email"));

    }
}
