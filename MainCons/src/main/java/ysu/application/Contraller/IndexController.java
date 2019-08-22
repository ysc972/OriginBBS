package ysu.application.Contraller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import com.netflix.client.http.HttpRequest;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;
import ysu.application.service.IndexService;
import ysu.application.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/index")
    public String getpost(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {

        PageInfo pageInfo=indexService.getAll(pageNum);
        List<Post> pageInfoList=pageInfo.getList();
        String infolist= JSON.toJSONString(pageInfoList);
        System.out.println(infolist);
        List<PostVo> postvo=indexService.getvo(infolist);
        List<PostVo> toplist=indexService.getTop();
        model.addAttribute("TopList",toplist);
        model.addAttribute("PostVolist",postvo);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    @RequestMapping("/gologin")
    public String gologin(HttpServletRequest request,String url,String sufix){

        System.out.println(123);
        if(!sufix.equals("")){
            return "redirect:http://192.168.242.1:8011/tologin?url="+url+"&sufix="+sufix;
        }

        return "redirect:http://192.168.242.1:8011/tologin?url="+url;
    }


}
