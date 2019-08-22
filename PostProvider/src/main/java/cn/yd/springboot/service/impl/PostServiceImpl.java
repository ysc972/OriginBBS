package cn.yd.springboot.service.impl;

import cn.yd.springboot.mapper.*;
import cn.yd.springboot.po.*;
import cn.yd.springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private SectionMapper sectionMapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ViewlikeMapper viewlikeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveLabels(String labels,int postId) {
        System.out.println("1");
        String[] label = labels.split(" ");
        Label label1 = new Label();
        label1.setPostId(postId);
        for(int i=0;i<label.length;i++){
            label1.setLabel(label[i]);
            labelMapper.insertSelective(label1);
        }
        System.out.println("2");
        return true;
    }

    @Override
    public Integer saveContent(Content content) {

        contentMapper.insertSelective(content);
        Integer contentId = content.getId();
        return contentId;
    }

    @Override
    public Integer savePost(Post post) {
        postMapper.insertSelective(post);
        return post.getId();
    }

    @Override
    public Integer findSectionId(String section_name) {

        SectionExample sectionExample = new SectionExample();
        SectionExample.Criteria criteria = sectionExample.createCriteria();
        criteria.andSectionNameEqualTo(section_name);
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        return sectionList.get(0).getId();
    }

    @Override
    public boolean updateContentPostid(int contentId, int postId) {
        Content content = new Content();
        content.setId(contentId);
        content.setPostId(postId);
        contentMapper.updateByPrimaryKeySelective(content);
        return true;
    }

    @Override
    public Post findPostById(int postId) {
        Post post = postMapper.selectByPrimaryKey(postId);
        return post;
    }

    @Override
    public List<Label> findLabelsByPostid(int postId) {
        List<Label> labelList = new ArrayList<Label>();
        LabelExample labelExample = new LabelExample();
        LabelExample.Criteria criteria = labelExample.createCriteria();
        criteria.andPostIdEqualTo(postId);
        labelList = labelMapper.selectByExample(labelExample);
        return labelList;
    }

    @Override
    public Content findContentByPostid(int postId) {
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andPostIdEqualTo(postId);
        List<Content> contentList = contentMapper.selectByExample(contentExample);
        return contentList.get(0);
    }

    @Override
    public List<List<Comment>> findCommentsByPostid(int postId) {
        /*先找到该帖子下的所有评论*/
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andPostIdEqualTo(postId);
        List<Comment> tempList = commentMapper.selectByExample(commentExample);
        /*再找所有根级评论*/
        ArrayList list = new ArrayList();
        for(Comment comment:tempList){
            if(comment.getParentId()==0){
                ArrayList temp = new ArrayList();
                temp.add(comment);
                int id = comment.getId();
                for(Comment comment1:tempList){
                    if(comment1.getParentId()==id) {
                        temp.add(comment1);
                    }
                }
                list.add(temp);
            }
        }
        return list;
    }

    @Override
    public boolean saveComment(Comment comment) {
        commentMapper.insertSelective(comment);
        return true;
    }

    @Override
    public boolean uploadPost(Post post) {
        postMapper.updateByPrimaryKeySelective(post);
        return true;
    }

    @Override
    public Viewlike findViewlike(int userId, int postId) {
        ViewlikeExample viewlikeExample = new ViewlikeExample();
        ViewlikeExample.Criteria criteria = viewlikeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andPostIdEqualTo(postId);
        List<Viewlike> list = viewlikeMapper.selectByExample(viewlikeExample);
        if(list.size() == 0)
            return null;
        return list.get(0);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
