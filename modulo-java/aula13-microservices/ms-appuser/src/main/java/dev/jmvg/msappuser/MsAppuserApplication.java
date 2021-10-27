package dev.jmvg.msappuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsAppuserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAppuserApplication.class, args);
    }

}
