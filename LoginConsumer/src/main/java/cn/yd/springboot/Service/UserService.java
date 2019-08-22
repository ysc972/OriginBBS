package cn.yd.springboot.Service;

import cn.yd.springboot.po.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@FeignClient("LoginProvider")
@Service
public interface UserService {
    @RequestMapping(value = "/privder_login", method = RequestMethod.POST)
    String login(@RequestParam("username") String username, @RequestParam("password")String password);
    @RequestMapping(value = "/privder_isHaveByUsername",method = RequestMethod.POST)
     boolean isHaveByUserName(@RequestParam String userJson);
    @RequestMapping(value = "/privder_isHaveByEmail",method = RequestMethod.POST)
    boolean isHaveByEmail(@RequestParam String userJson);
    @RequestMapping(value = "/privde_regist",method = RequestMethod.POST)
    int regist(@RequestParam String userJson);


}

