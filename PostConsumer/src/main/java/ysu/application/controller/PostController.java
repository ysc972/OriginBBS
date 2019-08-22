package ysu.application.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ysu.application.fastdfs.FastDFSClient;
import ysu.application.fastdfs.ImgInfo;
import ysu.application.po.*;
import ysu.application.service.PostFeignService;
import com.alibaba.fastjson.JSON;

import java.util.Date;
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
        post.setCreateTime(new Date());
        String postString = JSON.toJSONString(post);
        Integer postId = postFeignService.savePost(postString);
        postFeignService.updateContentPostid(contentId,postId);
        postFeignService.saveLabels(postQueryVo.getLabels(),postId);
        return "page-create-topic";
    }

    @GetMapping("/findPostById")
    public String findPostById(Model model){

        int postId = 41;
        User user = new User();
        user.setId(2);
        user.setUsername("小新");
        Viewlike viewlike = postFeignService.findViewlike(user.getId(),postId);
        model.addAttribute("viewlike",viewlike);
        Post post = postFeignService.findPostById(postId);
        List<Label> labelList = postFeignService.findLabelsByPostid(postId);
        Content content = postFeignService.findContentByPostid(postId);
        model.addAttribute("content",content);
        model.addAttribute("labelList",labelList);
        model.addAttribute("post",post);
        List<List<Comment>> commentLists = postFeignService.findCommentsByPostid(postId);
        model.addAttribute("commentLists",commentLists);
        System.out.println(commentLists);
        return "page-single-topic";
    }

    @PostMapping("/uploadComment")
    public String uploadComment(Comment comment){

        String commentString = JSON.toJSONString(comment);
        boolean bool = postFeignService.saveComment(commentString);
        System.out.println(bool);
        return "redirect:findPostById";
    }

    @PostMapping("/upadatePost")
    @ResponseBody
    public boolean upadatePost(Post post){
        String postString = JSON.toJSONString(post);
        boolean bool = postFeignService.uploadPost(postString);
        System.out.println(bool);
        return true;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public ImgInfo uploadFile(MultipartFile file) throws Exception {

        String originalName = file.getOriginalFilename();// 获取原文件名称
        String mytype = originalName.substring(originalName.lastIndexOf(".")+1);
        FastDFSClient fastdfs = new FastDFSClient("classpath:client.conf");
        String result = "http://123.56.220.42/"+fastdfs.uploadFile(file.getBytes(), mytype);
        String[] values = { result };
        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setError(0);
        imgInfo.setUrl(values);
        System.out.println(imgInfo.toString());
        return imgInfo;
    }

}
