package app;

import app.properties.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringBootApp {

    private final MyProperties myProperties;

    public SpringBootApp(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApp.class, args);
    }
    
    @PostConstruct
    public void init() {
        System.out.println("myProperties.getHeight() = " + myProperties.getHeight());
    }
}
