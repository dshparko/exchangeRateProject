package by.dshparko.exchangerateproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeRateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateProjectApplication.class, args);
    }

}
