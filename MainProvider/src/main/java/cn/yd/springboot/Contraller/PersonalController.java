package cn.yd.springboot.Contraller;

import cn.yd.springboot.service.PersonalService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ysu.Model.po.*;

import java.util.List;

@RestController
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @RequestMapping(value = "getPersonalPageInfo",method = RequestMethod.POST)
    PageInfo<Post> getPersonalPageInfo(@RequestParam("String") int userid,@RequestParam("pageNum")int pageNum)
    {
        return personalService.getPersonalPageInfo(userid,pageNum);
    }
    @RequestMapping(value = "getPersonalMessage",method = RequestMethod.POST)
    List<Message> getPersonalMessage(@RequestParam("userid") int userid)
    {
        return personalService.getPersonalMessage(userid);
    }
    @RequestMapping(value = "getSystemMessage",method = RequestMethod.POST)
    List<Message>getSystemMessage(@RequestParam("userid") int userid)
    {
        return personalService.getSystemMessage(userid);

    }
//    @RequestMapping(value = "getAttentionUser",method = RequestMethod.POST)
//    List<User> getAttentionUser(@RequestParam("userid") int userid)
//    {
//        return personalService.getAttentionUser(userid);
//    }
//
//
//    @RequestMapping(value = "getPersonalCommentVo",method = RequestMethod.POST)
//    List<CommentVo> getPersonalCommentVo(@RequestParam("userid") int userid)
//    {
//        return personalService.getPersonCommentVo(userid);
//    }

}
