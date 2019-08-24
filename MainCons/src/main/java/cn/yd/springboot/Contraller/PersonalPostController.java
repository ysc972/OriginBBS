package cn.yd.springboot.Contraller;

import cn.yd.springboot.po.AttentionVo;
import cn.yd.springboot.po.User;
import cn.yd.springboot.service.IndexService;
import cn.yd.springboot.service.PersonalPostService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ysu.Model.po.CommentVo;
import ysu.Model.po.Message;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PersonalPostController {
    @Autowired
    private PersonalPostService personalPostService;
    @Autowired
    private IndexService indexService;
    @RequestMapping("getPersonalPost")
    public String getPersonalPost(Model model,@RequestParam(value = "pageNum",defaultValue ="1")int pagenum,@RequestParam("userId")int userid,HttpSession session)
    {
        model.addAttribute("ziji", false);
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (user.getId() == userid) {
                model.addAttribute("ziji", true);
            }
        }
        PageInfo<Post> pageInfo=personalPostService.getPersonalPageInfo(userid,pagenum);
        String list= JSON.toJSONString(pageInfo.getList());
        List<PostVo> postVoList=indexService.getvo(list);
        cn.yd.springboot.po.User curUser =indexService.getUser(userid);
        model.addAttribute("curUser",curUser);
        model.addAttribute("PersonalPostVo",postVoList);
        model.addAttribute("pageInfo",pageInfo);
        return "page-single-user";
    }
    @RequestMapping("getPersonalMessage")
    public String getPersonalMessage(Model model, @RequestParam("userId")int userid, HttpSession session) {

        model.addAttribute("ziji", false);
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (user.getId() == userid) {
                model.addAttribute("ziji", true);
            }
        }
            List<Message> messageList = personalPostService.getPersonalMessage(userid);
            List<Message> systemmessageList = personalPostService.getSystemMessage(userid);
            cn.yd.springboot.po.User curUser = indexService.getUser(userid);
            model.addAttribute("curUser", curUser);
            model.addAttribute("systemmessageList", systemmessageList);
            model.addAttribute("messageList", messageList);
            return "page-single_threads";
    }

    @RequestMapping("getPersonCommentVo")
    public String getPersonalComment(Model model,@RequestParam("userId")int userid,HttpSession session )
    {
        model.addAttribute("ziji", false);

        if(session.getAttribute("user")!=null){
            User user=(User)session.getAttribute("user");
            if(user.getId()==userid){
                model.addAttribute("ziji",true);
            }
        }
        List<CommentVo> list=personalPostService.getPersonalCommentVo(userid);
        cn.yd.springboot.po.User curUser =indexService.getUser(userid);
        model.addAttribute("curUser",curUser);
        model.addAttribute("personalCommentVo",list);
        return "page-single_replies";
    }
    @RequestMapping("getAttentionUser")
    public String getAttentionVo(Model model,@RequestParam("userId")int userid,HttpSession session)
    {
        model.addAttribute("ziji", false);
        if(session.getAttribute("user")!=null){
            User user=(User)session.getAttribute("user");
            if(user.getId()==userid){
                model.addAttribute("ziji",true);
            }
        }
        cn.yd.springboot.po.User curUser =indexService.getUser(userid);
        model.addAttribute("curUser",curUser);
        List<AttentionVo> userList=personalPostService.getAttentionVo(userid);
        model.addAttribute("attentionVoList",userList);
        return "page-single_followers";
    }

    @RequestMapping("/followUser")
    @ResponseBody
    public void followUser(@RequestParam("id") int id,HttpSession session){
        User user=(User)session.getAttribute("user");
       personalPostService.followUser(user.getId(),id);
    }
}
