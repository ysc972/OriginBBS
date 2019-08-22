package cn.yd.springboot.service;

import cn.yd.springboot.po.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "PostProvider")
public interface PostFeignService {

    @GetMapping("/findUserById")
    User findUserById(@RequestParam("id") int id) throws Exception;

    @GetMapping("/findAllUsers")
    List<User> findAllUsers() throws Exception;

    @GetMapping("/findSectionId/{section_name}")
    Integer findSectionId(@PathVariable("section_name") String section_name);

    @RequestMapping(value = "/saveContent", method = RequestMethod.POST, consumes = "application/json")
    Integer saveContent(@RequestParam("content") String content);

    @RequestMapping(value = "/savePost",method = RequestMethod.GET)
    Integer savePost(@RequestParam("post") String post);

    @RequestMapping(value = "/saveLabels",method = RequestMethod.POST)
    boolean saveLabels(@RequestParam("labels") String labels,@RequestParam("postId") int postId);

    @GetMapping(value = "/findPostById")
    Post findPostById(@RequestParam("postId") int postId);

    @GetMapping(value = "/findViewlike")
    Viewlike findViewlike(@RequestParam("userId") int userId, @RequestParam("postId") int postId);

    @GetMapping(value = "/findContentByPostid")
    Content findContentByPostid(@RequestParam("postId") int postId);

    @GetMapping(value = "/updateContentPostid")
    boolean updateContentPostid(@RequestParam("contentId") int contentId,@RequestParam("postId") int postId);

    @PostMapping(value = "findLabelsByPostid")
    List<Label> findLabelsByPostid(@RequestParam("postId") int postId);

    @PostMapping(value = "findCommentsByPostid")
    List<List<Comment>> findCommentsByPostid(@RequestParam("postId") int postId);

    @PostMapping(value = "saveComment")
    boolean saveComment(@RequestParam("comment") String comment);

    @PostMapping(value = "uploadPost")
    boolean uploadPost(@RequestParam("post") String post);

    @PostMapping(value = "uploadFile")
    boolean uploadFile(@RequestParam("file") String file);

    @PostMapping(value = "saveFilePath")
    boolean saveFilePath(@RequestParam("file") String file);

}
