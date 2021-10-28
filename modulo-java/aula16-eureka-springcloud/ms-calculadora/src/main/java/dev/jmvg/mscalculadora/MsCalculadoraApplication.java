package dev.jmvg.mscalculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "mstabela")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MsCalculadoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCalculadoraApplication.class, args);
    }

}
