package cn.yd.springboot.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="service")
@Service
public interface LoginService {


    @RequestMapping("/tologin")
    public String tologin();

}
