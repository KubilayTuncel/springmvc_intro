package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
@ComponentScan("com.tpe") //Bu anatation yazdigimiz package altindaki tüm class'lari tarar ve
                          //hangi class'larda  component anatatin olanlari bulur.
                          //defalt degeri de normalde com.tpe dir. yani bulundugu package'dir
public class AppConfiguration {

    @Bean //bu anatation i sadece methodlarin yüerine kullaniriz. Ayrica bu gibi asagidaki methodlar core javanin
    //hazir classlarindan methodlari almamizi saglar, bu yüzden bu anatation ihtiyac duyariz.
    public Point point() {
        return new Point(56,45);
    }

}
