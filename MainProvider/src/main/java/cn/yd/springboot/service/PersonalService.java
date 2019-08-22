package cn.yd.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.mapper.AttentionMapper;
import ysu.Model.mapper.MessageMapper;
import ysu.Model.mapper.PostMapper;
import ysu.Model.mapper.UserMapper;
import ysu.Model.po.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttentionMapper attentionMapper;
   public PageInfo<Post> getPersonalPageInfo(@RequestParam("String") int userid,@RequestParam("pageNum")int pageNum)
    {
        PageHelper.startPage(pageNum,5);
        PostExample example=new PostExample();
        PostExample.Criteria criteria=example.createCriteria();
        criteria.andTypeNotEqualTo("-1");
        criteria.andUserIdEqualTo(userid);
        List<Post> list=postMapper.selectByExample(example);
        PageInfo<Post> pageInfo=new PageInfo<Post>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public List<Message> getPersonalMessage(@RequestParam("userid") int userid)
    {
        MessageExample messageExample=new MessageExample();
        MessageExample.Criteria criteria =messageExample.createCriteria();
        criteria.andReciveUserIdEqualTo(userid);
        criteria.andSendUserIdNotEqualTo(-1);
        List<Message> messageList=messageMapper.selectByExample(messageExample);
        return messageList;
    }
   public List<Message>getSystemMessage(@RequestParam("userid") int userid)
    {

        MessageExample messageExample=new MessageExample();
        MessageExample.Criteria criteria =messageExample.createCriteria();
        criteria.andReciveUserIdEqualTo(userid);
        criteria.andSendUserIdEqualTo(-1);
        List<Message> messageList=messageMapper.selectByExample(messageExample);
        return messageList;
    }
    List<User> getAttentionUser(@RequestParam("userid") int userid)
    {
        AttentionExample attentionExample=new AttentionExample();
        AttentionExample.Criteria criteria1=attentionExample.createCriteria();
        criteria1.andUserIdEqualTo(userid);
        List<Attention> attentionList=attentionMapper.selectByExample(attentionExample);
        List<User> userList=new ArrayList<User>();
        for (Attention attention : attentionList) {

            userList.add(userMapper.selectByPrimaryKey(attention.getAttentionId()));
        }


        return userList;
    }


}
