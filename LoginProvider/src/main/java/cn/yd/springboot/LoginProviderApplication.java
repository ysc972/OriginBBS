package cn.yd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.yd.springboot.mapper")
public class LoginProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginProviderApplication.class,args);

    }
}
