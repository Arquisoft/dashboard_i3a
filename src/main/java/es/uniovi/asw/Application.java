package es.uniovi.asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("es.uniovi.asw")
public class Application {

	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}