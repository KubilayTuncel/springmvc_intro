package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {

    public static void main(String[] args) {


        Message message = new Message();
        message.setMessage("Siparisiniz verildi.");

        //!!Config dosyasini gösteriyoruz.
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        //bean talep ediyoruz. Bu sekilde biz MailService class'in dan obje olusturmak yerine Ann.Con.App.Context
        //sayesinde Component anatation sayesinde bizim yrimize context üzerinden olsuturmamizi sagliyor.
       // MailService service = context.getBean(MailService.class); interface olunca
        // hangi child class ta bean olusturacagini anlayamadigi icin exception firlatir.
        //Bu yüzden asagidaki gibi yapariz.

        MessageService service = context.getBean("mailService", MessageService.class);
        MessageService service2 = context.getBean("mailService", MessageService.class);

        if (service == service2) {
            System.out.println("Ayni");
        }else{
            System.out.println("Farkli");
        }

        service.sendMessage(message);

        context.close(); //programi kapatirken olsan beanleri yok ediyoruz.

    }
}
