package cn.yd.springboot.controller;


import cn.yd.springboot.po.User;
import cn.yd.springboot.service.impl.UserServiceImpl;
import cn.yd.springboot.util.EncryptUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    /**
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/privder_login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password")String password) {

        ObjectMapper objectMapper=new ObjectMapper();
        String json;
        try {
             json=objectMapper.writeValueAsString(userService.isLogin(username,password));
        } catch (JsonProcessingException e) {
            json="null";
            e.printStackTrace();

        }
        return json;
    }
    @RequestMapping(value = "/privder_isHaveByUsername",method = RequestMethod.POST)
    boolean isHaveByUserName(@RequestBody User user){
        return userService.isHaveByUserName(user.getUsername());
    }



    @RequestMapping(value = "/privder_isHaveByEmail",method = RequestMethod.POST)
    boolean isHaveByEmail(@RequestBody User user){
        return userService.isHaveByEmail(user.getEmail());
    }

    @RequestMapping(value = "/privde_regist",method = RequestMethod.POST)
    int regist(@RequestBody User user){
        return userService.insert(user);
    }




}
