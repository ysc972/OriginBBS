package cn.yd.springboot.service;

import cn.yd.springboot.po.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostService {

    boolean saveLabels(String labels,int postId);
    Integer saveContent(Content content);
    Integer savePost(Post post);
    Integer findSectionId(String section_name);
    boolean updateContentPostid(int contentId,int postId);
    Post findPostById(int postId);
    List<Label> findLabelsByPostid(int postId);
    Content findContentByPostid( int postId);
    List<List<Comment>> findCommentsByPostid(int  postId);
    boolean saveComment(Comment comment);
    boolean uploadPost(Post post);
    Viewlike findViewlike(int userId,int postId);
    User findUserById(int id);
}
