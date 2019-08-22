package ysu.application.Contraller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.po.*;
import ysu.application.service.IndexService;
import ysu.application.service.PersonalPostService;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class PersonalPostController {
    @Autowired
    private PersonalPostService personalPostService;
    @Autowired
    private IndexService indexService;
    @RequestMapping("getPersonalPost")
    public String getPersonalPost(Model model,@RequestParam("pageNum")int pagenum)
    {
        int userid=1;
        PageInfo<Post> pageInfo=personalPostService.getPersonalPageInfo(userid,pagenum);
        String list= JSON.toJSONString(pageInfo.getList());
        List<PostVo> postVoList=indexService.getvo(list);
        model.addAttribute("PersonalPostVo",postVoList);
        model.addAttribute("pageInfo",pageInfo);
        return "page-single-user";
    }
    @RequestMapping("getPersonalMessage")
    public String getPersonalMessage(Model model)
    {
        int userid=1;
        List<Message> messageList=personalPostService.getPersonalMessage(userid);
        List<Message> systemmessageList=personalPostService.getSystemMessage(userid);
        model.addAttribute("systemmessageList",systemmessageList);
        model.addAttribute("messageList",messageList);
        return "page-single_threads";
    }
    @RequestMapping("getPosersonCommentVo")
    public String getPersonalComment(Model model,@RequestParam("pageNum")int pagenum)
    {
        int userid=1;
        PageInfo<Comment> pageInfo=personalPostService.getPersonalCommentPageInfo(userid,pagenum);
        model.addAttribute("personalCommentVo",pageInfo);
        return "page-single_replies";
    }
}
