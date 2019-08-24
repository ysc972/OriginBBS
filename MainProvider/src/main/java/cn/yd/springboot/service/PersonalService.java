package cn.yd.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.mapper.*;
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
    @Autowired
    private CommentMapper commentMapper;

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
    public List<Message> getSystemlMessage(@RequestParam("userid") int userid)
    {
        MessageExample messageExample=new MessageExample();
        MessageExample.Criteria criteria =messageExample.createCriteria();
        criteria.andReciveUserIdEqualTo(userid);
        criteria.andSendUserIdNotEqualTo(-1);
        criteria.andSendUserIdEqualTo(-1);
        criteria.andIsReadEqualTo(0);
        List<Message> messageList=messageMapper.selectByExample(messageExample);
        return messageList;
    }
    public List<Message> getPersonalMessage(@RequestParam("userid") int userid)
    {
        MessageExample messageExample=new MessageExample();
        MessageExample.Criteria criteria =messageExample.createCriteria();
        criteria.andReciveUserIdEqualTo(userid);
        criteria.andSendUserIdNotEqualTo(-1);
        criteria.andIsReadEqualTo(0);
        List<Message> messageList=messageMapper.selectByExample(messageExample);
        System.out.println(messageList);
        return messageList;
    }
   public List<Message>getSystemMessage(@RequestParam("userid") int userid)
    {

        MessageExample messageExample=new MessageExample();
        MessageExample.Criteria criteria =messageExample.createCriteria();
        criteria.andReciveUserIdEqualTo(userid);
        criteria.andSendUserIdEqualTo(-1);
        List<Message> messageList=messageMapper.selectByExample(messageExample);
        System.out.println(messageList);
        return messageList;
    }
    public List<AttentionVo> getAttentionVo(@RequestParam("userid") int userid)
    {
        AttentionExample attentionExample=new AttentionExample();
        AttentionExample.Criteria criteria1=attentionExample.createCriteria();
        criteria1.andUserIdEqualTo(userid);
        List<Attention> attentionList=attentionMapper.selectByExample(attentionExample);
        List<AttentionVo> attentionVoList=new ArrayList<>();
        for (Attention attention : attentionList) {
            AttentionVo attentionVo=new AttentionVo();
            attentionVo.setUser(userMapper.selectByPrimaryKey(attention.getAttentionId()));
            attentionVo.setAttention(attention);
            attentionVoList.add(attentionVo);
        }


        return attentionVoList;
    }

    public List<CommentVo> getPersonalCommentVo(@RequestParam("userid") int userid)
    {
        List<CommentVo> commentVoList=new ArrayList<>();
        CommentExample example=new CommentExample();
        CommentExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(Integer.toString(userid));
        List<Comment> commentList=commentMapper.selectByExample(example);
        for (Comment comment : commentList) {
            int postid=comment.getPostId();
            Post post=postMapper.selectByPrimaryKey(postid);
            List<Comment> commentList1=new ArrayList<>();
            commentList1.add(comment);
            CommentVo commentVo=new CommentVo();
            commentVo.setPost(post);
            commentVo.setCommentList(commentList1);
            commentVoList.add(commentVo);
        }


        return commentVoList;
    }
    public void followUser(int userid,int fid){
        AttentionExample attentionExample = new AttentionExample();
        AttentionExample.Criteria criteria = attentionExample.createCriteria();
        criteria.andUserIdEqualTo(userid);
        criteria.andAttentionIdEqualTo(fid);
        List<Attention> attentionList = attentionMapper.selectByExample(attentionExample);
        if(attentionList.size() == 0){
            Attention attention = new Attention();
            attention.setUserId(userid);
            attention.setAttentionId(fid);
            attentionMapper.insertSelective(attention);
        }
    }
}
