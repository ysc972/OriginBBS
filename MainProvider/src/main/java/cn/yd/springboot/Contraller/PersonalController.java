package cn.yd.springboot.Contraller;

import cn.yd.springboot.service.PersonalService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ysu.Model.po.AttentionVo;
import ysu.Model.po.CommentVo;
import ysu.Model.po.Message;
import ysu.Model.po.Post;

import java.util.List;

@RestController
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @RequestMapping(value = "getPersonalPageInfo",method = RequestMethod.POST)
   public PageInfo<Post> getPersonalPageInfo(@RequestParam("String") int userid, @RequestParam("pageNum")int pageNum)
    {
        return personalService.getPersonalPageInfo(userid,pageNum);
    }
    @RequestMapping(value = "getPersonalMessage",method = RequestMethod.POST)
    public List<Message> getPersonalMessage(@RequestParam("userid") int userid)
    {
        return personalService.getPersonalMessage(userid);
    }
    @RequestMapping(value = "getSystemMessage",method = RequestMethod.POST)
    public List<Message>getSystemMessage(@RequestParam("userid") int userid)
    {
        return personalService.getSystemMessage(userid);

    }
    @RequestMapping(value = "getAttentionVo",method = RequestMethod.POST)
    public List<AttentionVo> getAttentionVo(@RequestParam("userid") int userid)
    {
        return personalService.getAttentionVo(userid);
    }


    @RequestMapping(value = "getPersonalCommentVo",method = RequestMethod.POST)
    public List<CommentVo> getPersonalCommentVo(@RequestParam("userid") int userid)
    {
        return personalService.getPersonalCommentVo(userid);
    }

    @RequestMapping(value = "followUser",method = RequestMethod.POST)
    void followUser(@RequestParam("uid") int userid,@RequestParam("fid") int fid){
        System.out.println(1);
        personalService.followUser(userid,fid);
    }
}
