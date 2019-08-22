package cn.yd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PostConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostConsumerApplication.class,args);
    }

   /* @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }*/
}
