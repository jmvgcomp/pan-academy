package dev.jmvg.mstabela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsTabelaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTabelaApplication.class, args);
    }

}
