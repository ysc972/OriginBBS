package cn.yd.springboot.Contraller;
import cn.yd.springboot.po.User;
import cn.yd.springboot.service.IndexService;
import cn.yd.springboot.service.LoginService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/index")
    public String getpost(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpSession session) {

        System.out.println(session.getAttribute("islogin"));
        if(session.getAttribute("islogin")==null){
            session.setAttribute("islogin",false);
        }

        System.out.println(11111);
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

    @RequestMapping("/findPost")
    public String findPost(@RequestParam(value = "postId")int postId){
        return "redirect:http://192.168.242.1:8017/findPostById?postId="+postId;
    }

    @RequestMapping("/toCreatePost")
    public String toCreatePost(){
        return "redirect:http://192.168.242.1:8017/toCreatePost";
    }

    @RequestMapping("/toPageTab")
    public String toPageTab(){

        return "page-tabs";
    }

}
