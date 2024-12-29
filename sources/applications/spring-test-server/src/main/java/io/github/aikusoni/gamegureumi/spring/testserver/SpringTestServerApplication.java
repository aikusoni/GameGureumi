package io.github.aikusoni.gamegureumi.spring.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "io.github.aikusoni.gamegureumi.spring")
@ConfigurationPropertiesScan(basePackages = "io.github.aikusoni.gamegureumi.spring")
public class SpringTestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestServerApplication.class, args);
    }

}
