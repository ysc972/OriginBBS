package cn.yd.springboot.controller;

import cn.yd.springboot.po.Content;
import cn.yd.springboot.po.Label;
import cn.yd.springboot.po.Post;
import cn.yd.springboot.po.Section;
import cn.yd.springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/findSectionId/{section_name}")
    Integer findSectionId(@PathVariable("section_name") String section_name){
        return postService.findSectionId(section_name);
    }

    @RequestMapping(value = "/saveContent", method = RequestMethod.POST, consumes = "application/json")
    Integer saveContent(@RequestParam("content") String content){
        Content content1 = JSON.parseObject(content,Content.class);
        return postService.saveContent(content1);
    }

    @RequestMapping(value = "/savePost",method = RequestMethod.GET)
    Integer savePost(@RequestParam("post") String post){
        Post post1 = JSON.parseObject(post,Post.class);
        return postService.savePost(post1);
    }

    @RequestMapping(value = "/updateContentPostid",method = RequestMethod.GET)
    boolean updateContentPostid(@RequestParam("contentId") int contentId,@RequestParam("postId") int postId){
        postService.updateContentPostid(contentId,postId);
        return true;
    }

    @RequestMapping(value = "saveLabels", method = RequestMethod.POST)
    boolean saveLabels(@RequestParam("labels") String labels,@RequestParam("postId") int postId){

        postService.saveLabels(labels,postId);

        return true;
    }

    @RequestMapping(value = "findPostById",method = RequestMethod.GET)
    Post findPostById(@RequestParam("postId") int postId){
        return postService.findPostById(postId);
    }

    @RequestMapping(value = "findContentByPosyid",method = RequestMethod.GET)
    Content findContentByPosyid(@RequestParam("postId") int postId){
        return postService.findContentByPosyid(postId);
    }

    @RequestMapping(value = "findLabelsByPostid",method = RequestMethod.POST)
    List<Label> findLabelByPostid(@RequestParam("postId") int postId){
        return postService.findLabelsByPostid(postId);
    }
}
