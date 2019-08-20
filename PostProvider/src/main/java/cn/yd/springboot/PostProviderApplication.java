package cn.yd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "cn.yd.springboot.mapper")
@EnableTransactionManagement
public class PostProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostProviderApplication.class,args);

    }
}
