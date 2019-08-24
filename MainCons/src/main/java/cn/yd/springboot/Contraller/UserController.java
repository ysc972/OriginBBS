package cn.yd.springboot.Contraller;


import cn.yd.springboot.po.User;
import cn.yd.springboot.service.UploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UploadService uploadService;


    @RequestMapping("/update_user")
    public String updateUser( User user, MultipartFile file,HttpSession session,@RequestParam("url") String url,String sufix) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        url=url+"?"+sufix;
        String userJSON="";
        userJSON=objectMapper.writeValueAsString(user);
        String newUserJson=uploadService.update(userJSON,file);
        User newUser=objectMapper.readValue(newUserJson,User.class);
        session.setAttribute("user",newUser);
        return "redirect:"+url;
    }




}
