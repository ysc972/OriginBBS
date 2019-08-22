package cn.yd.springboot.controller;

import cn.yd.springboot.Service.UploadService;
import cn.yd.springboot.Service.UserService;
import cn.yd.springboot.po.User;

import cn.yd.springboot.po.UserVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadService uploadService;

    /**
     * 去登陆页面
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(){
        return "page-login";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param model
     * @param session
     * @param URl
     * @return
     */
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
                session.setAttribute("user",user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:tosettings";
    }

    /**
     * 去注册页面
     * @return
     */
    @RequestMapping("/toregist")
    public String regiset(){return "page-signup";}

    /**
     * 去个人设置页面
     * @return
     */
    @RequestMapping("/tosettings")
    public String toSettings(){return"page-single_settings";}

    @RequestMapping("/update_user")
    public String updateUser( User user, MultipartFile file,HttpSession session) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        String userJSON="";
        userJSON=objectMapper.writeValueAsString(user);
        String newUserJson=uploadService.update(userJSON,file);
        User newUser=objectMapper.readValue(newUserJson,User.class);
        session.setAttribute("user",newUser);
        return "redirect:tosettings";

    }

    /**
     * 注册
     * @param user
     * @param session
     * @param model
     * @param URL
     * @return
     */
    @RequestMapping("/regist")
    public String regist(User user, HttpSession session, Model model,String URL) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String userJson="";
        userJson=objectMapper.writeValueAsString(user);
       if(userService.isHaveByUserName(userJson)) {
           model.addAttribute("erroUsername", "用户名已存在");
       }
       if(userService.isHaveByEmail(userJson)){
           model.addAttribute("erroEmail","邮箱已存在");
       }
       if(!userService.isHaveByEmail(userJson)&&!userService.isHaveByUserName(userJson)){

           userService.regist(userJson);
           session.setAttribute("user",user);
           session.setAttribute("islogin",true);
           return "index";
       }
       return "page-signup";


    }

}
