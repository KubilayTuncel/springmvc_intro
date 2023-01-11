package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component ("mailService")
@Scope("prototype") //Bu anatation getBean() her cagirildiginda yeni obje üreterek getirir. Ve Bean default da singleton'dir.
//Scope anatation bu sayede eger run class'in da bean'den getBean denildiginde  farkli yeni obje olusturur.
public class MailService implements MessageService {

    @Value("${app.email}") //Bu anatation ile resources klasöründe bulunan properties dosyasindaki degeri almamizi sagliyor.
    private String email;

/* 1)Field Injection
    @Autowired //bu anatation altindaki tanimlamaya bakar ve dependency injectin yapar. Bu sekilde istedigim yerde kullanabilirim.
            //Eger obje hic olusturulmamis ise singleton method olarak obje olusturur. eger daha önceden bu obje olusturulmus ise
            //o onjeyi alir
    @Qualifier("dbRepository") //Autowire kullandigim icin bu anatation ile hangi class'i kullacagimizi belrilemek icin kullaniyoruz.
    Repository repository;

 */
/*
    //2) Setter Injection

    private Repository repository;

    @Autowired
    @Qualifier("fileRepository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

 */
    //3)Constractor Injection
    private Repository repository;

    @Autowired //trick: Eger class icinde bir tane cont. varsa Autowire gerek yok.
    public MailService(@Qualifier("dbRepository") Repository repository) {
        this.repository = repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben mail servisiyim, size bir mesaj gönderiyorum : "+message.getMessage());
        repository.saveMessage(message);
    }
}
