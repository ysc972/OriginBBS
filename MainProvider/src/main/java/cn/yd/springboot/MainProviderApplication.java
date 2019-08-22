package cn.yd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages= "ysu.Model.mapper")

public class MainProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainProviderApplication.class,args);
    }
}
