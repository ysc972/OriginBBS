package cn.yd.springboot.controller;


import cn.yd.springboot.fastdfs.FastDFSClient;
import cn.yd.springboot.po.User;
import cn.yd.springboot.service.impl.UserServiceImpl;
import cn.yd.springboot.util.EncryptUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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
//    @RequestMapping(value = "/privde_update",method = RequestMethod.POST)
//    boolean update(String userJSON,String fileJson) throws Exception {
//        ObjectMapper objectMapper=new ObjectMapper();
//        User user=objectMapper.readValue(userJSON,User.class);
//        if(fileJson.equals("")){
//            userService.update(user);
//            return true;
//        }
//        MultipartFile file=objectMapper.readValue(fileJson,MultipartFile.class);
//        FastDFSClient Client = new FastDFSClient("classpath:tracker.conf");
//        String Newname=Client.uploadFile(file.getBytes());
//        System.out.println(Newname);
//
//
//        return false;
//    }


    @PostMapping(value = "/privde_update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String  update(@RequestParam String userJSON, @RequestPart(value = "file") MultipartFile file) throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        User user=objectMapper.readValue(userJSON,User.class);
        System.out.println(user.getId());
        if(file!=null){
            FastDFSClient Client = new FastDFSClient("classpath:tracker.conf");
            String Newname=Client.uploadFile(file.getBytes());
            System.out.println(Newname);
            user.setPic(Newname);
        }
        userService.update(user);
        User newUser=userService.getUserById(user.getId());
        String newUserJson=objectMapper.writeValueAsString(newUser);
        return newUserJson;
    }



}
