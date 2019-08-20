package ysu.application.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ysu.application.po.*;

import java.util.List;

@FeignClient(value = "PostProvider")
public interface PostFeignService {

    @GetMapping("/findUserById/{id}")
    User findUserById(@PathVariable("id") int id) throws Exception;

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

    @GetMapping(value = "/findContentByPosyid")
    Content findContentByPosyid(@RequestParam("postId") int postId);

    @GetMapping(value = "/updateContentPostid")
    boolean updateContentPostid(@RequestParam("contentId") int contentId,@RequestParam("postId") int postId);

    @PostMapping(value = "findLabelsByPostid")
    List<Label> findLabelsByPostid(@RequestParam("postId") int postId);

    @PostMapping(value = "findContentByPostid")
    List<Label> findContentByPostid(@RequestParam("postId") int postId);


}
