package seleucus.wsp.HoneyChecker.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan({"seleucus.wsp.HoneyChecker"})
@ComponentScan({"seleucus.wsp.HoneyChecker"})
    public class HoneyCheckerServiceStarter {
        public static void main(String[] args) {
            SpringApplication.run(HoneyCheckerServiceStarter.class, args);

        }
    }