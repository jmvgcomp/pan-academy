package dev.jmvg.mscalculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@RibbonClient(name = "mstabela")
@EnableFeignClients
@SpringBootApplication
public class MsCalculoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCalculoApplication.class, args);
    }

}
