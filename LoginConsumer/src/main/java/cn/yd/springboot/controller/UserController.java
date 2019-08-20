package cn.yd.springboot.controller;

import cn.yd.springboot.Service.UserService;
import cn.yd.springboot.po.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/tologin")
    public String tologin(){
        return "page-login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password") String password, Model model,HttpSession session,String URl){
        String userJson=userService.login(username,password);
        if(userJson.equals("false")||userJson.equals("null")){
            model.addAttribute("erro","用户名或密码错误");
            return "page-login";
        }else{
            ObjectMapper objectMapper=new ObjectMapper();
            try {
                User user=objectMapper.readValue(userJson,User.class);
                session.setAttribute("islogin",true);
                session.setAttribute("user",userService.login(username,password));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "index";
    }
    @RequestMapping("/toregist")
    public String regiset(){return "page-signup";}


    @RequestMapping("/regist")
    public String regist(User user, HttpSession session, Model model,String URL){
       if(userService.isHaveByUserName(user)) {
           model.addAttribute("erroUsername", "用户名已存在");
       }
       if(userService.isHaveByEmail(user)){
           model.addAttribute("erroEmail","邮箱已存在");
       }
       if(!userService.isHaveByEmail(user)&&!userService.isHaveByUserName(user)){

           userService.regist(user);
           session.setAttribute("user",user);
           session.setAttribute("islogin",true);
           return "index";
       }
       return "page-signup";


    }

}
