package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.awt.*;
import java.util.Properties;

@Configuration
@ComponentScan("com.tpe") //Bu anatation yazdigimiz package altindaki tüm class'lari tarar ve
                          //hangi class'larda  component anatatin olanlari bulur.
                          //defalt degeri de normalde com.tpe dir. yani bulundugu package'dir
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    Environment environment;

    @Bean //bu anatation i sadece methodlarin üzerine kullaniriz. Ayrica bu gibi asagidaki methodlar core javanin
    //hazir classlarindan methodlari almamizi saglar, bu yüzden bu anatation ihtiyac duyariz.
    public Point point() {
        return new Point(56,45);
    }

    @Bean
    public Properties properties() {

        Properties properties = new Properties();
        properties.put("email",environment.getProperty("app.email"));


        return properties;
    }

}
