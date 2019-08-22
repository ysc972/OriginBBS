package cn.yd.springboot.service;

import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.po.*;

import java.util.List;
@FeignClient(value="MainProvider")
@Service
public interface PersonalPostService {
    @RequestMapping(value = "getPersonalPageInfo",method = RequestMethod.POST)
    PageInfo<Post> getPersonalPageInfo(@RequestParam("String") int userid,@RequestParam("pageNum")int pageNum);
    @RequestMapping(value = "getPersonalMessage",method = RequestMethod.POST)
    List<Message>getPersonalMessage(@RequestParam("userid") int userid);
    @RequestMapping(value = "getSystemMessage",method = RequestMethod.POST)
    List<Message>getSystemMessage(@RequestParam("userid") int userid);
    @RequestMapping(value = "getAttentionUser",method = RequestMethod.POST)
    List<User> getAttentionUser(@RequestParam("userid") int userid);
    @RequestMapping(value = "getPersonalCommentPageInfo",method = RequestMethod.POST)
    PageInfo<Comment> getPersonalCommentPageInfo(@RequestParam("userid") int userid,@RequestParam("pageNum")int pageNum);
    @RequestMapping(value = "getPersonalCommentVo",method = RequestMethod.POST)
    List<CommentVo> getPersonalCommentVo(@RequestParam("list") String list);

}

