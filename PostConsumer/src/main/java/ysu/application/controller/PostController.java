package ysu.application.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ysu.application.po.*;
import ysu.application.service.PostFeignService;
import com.alibaba.fastjson.JSON;

import java.util.List;


@Controller
public class PostController {

   /* @Autowired
    private RestTemplate restTemplate;
*/
    @Autowired
    private PostFeignService postFeignService;


    @GetMapping("/findUserById/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id") int id) throws Exception {

       // return restTemplate.getForEntity("http://127.0.0.1:8018/findUserById/{id}",User.class,id).getBody();
        return postFeignService.findUserById(id);
    }

    @GetMapping("/findAllUsers")
    @ResponseBody
    public Object findAllUsers() throws Exception {

        return postFeignService.findAllUsers();
    }

    @RequestMapping("/toCreatePost")
    public String toCreatePost(){

        return "page-create-topic";
    }

    @PostMapping("/uploadPost")
    public String uploadPost(PostQueryVo postQueryVo){

        Integer sectionId = postFeignService.findSectionId(postQueryVo.getSection().getSectionName());
        String content = JSON.toJSONString(postQueryVo.getContent());
        Integer contentId = postFeignService.saveContent(content);
        Post post = postQueryVo.getPost();
        post.setContentId(contentId.toString());
        post.setSectionId(sectionId);
        String postString = JSON.toJSONString(post);
        Integer postId = postFeignService.savePost(postString);
        postFeignService.updateContentPostid(contentId,postId);
        postFeignService.saveLabels(postQueryVo.getLabels(),postId);
        return "page-create-topic";
    }

    @GetMapping("/findPostById")
    public String findPostById(Model model){

        int postId = 37;
        Post post = postFeignService.findPostById(postId);
        List<Label> labelList = postFeignService.findLabelsByPostid(postId);
        Content content = postFeignService.findContentByPosyid(postId);
        model.addAttribute("content",content);
        model.addAttribute("labelList",labelList);
        model.addAttribute("post",post);
        return "page-single-topic";
    }
}
