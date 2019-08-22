package ysu.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages= "ysu.Model.mapper")

public class MainProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainProviderApplication.class,args);
    }
}
