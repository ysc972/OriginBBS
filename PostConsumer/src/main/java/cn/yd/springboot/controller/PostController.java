package cn.yd.springboot.controller;

import cn.yd.springboot.po.*;
import cn.yd.springboot.service.PostFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import cn.yd.springboot.fastdfs.FastDFSClient;
import cn.yd.springboot.fastdfs.ImgInfo;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
public class PostController {

   /* @Autowired
    private RestTemplate restTemplate;
*/
    @Autowired
    private PostFeignService postFeignService;

    @Autowired
    private SimpMessagingTemplate template;

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
    public String toCreatePost(Model model){
        List<Section> sectionList = postFeignService.findSections();
        model.addAttribute("sectionList",sectionList);
        return "page-create-topic";
    }

    @SendTo("/topic/greetings")
    @PostMapping("/uploadPost")
    public String uploadPost(PostQueryVo postQueryVo){

        String content1="您订阅的博主新发了一条帖子。";
        System.out.println(content1);
        template.convertAndSend("/topic/greetings",content1);
        System.out.println(content1);
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
        return "redirect:/findPostById?postId="+postId;
    }

    @RequestMapping("/gotologin")
    public String gotologin(HttpServletRequest request,String url,String sufix){
        if(!sufix.equals("")||sufix == null){
            return "redirect:http://192.168.242.1:8011/tologin?url="+url+"&sufix="+sufix;
        }
        return "redirect:http://192.168.242.1:8011/tologin?url="+url;
    }

    @RequestMapping("/getPersonalPost")
    public String getPersonalPost(HttpServletRequest request,String userId){

        return "redirect:http://192.168.242.1:8013/getPersonalPost?userId="+userId;
    }
    @GetMapping("/findPostById")
    public String findPostById(@RequestParam("postId") int postId, Model model, HttpSession session) throws Exception {

        Post post = postFeignService.findPostById(postId);
        User postuser = postFeignService.findUserById(post.getUserId());
        model.addAttribute("postuser",postuser);
        List<Label> labelList = postFeignService.findLabelsByPostid(postId);
        Content content = postFeignService.findContentByPostid(postId);
        model.addAttribute("content",content);
        model.addAttribute("labelList",labelList);
        model.addAttribute("post",post);
        List<List<CommentQueryVo>> comVoLists = postFeignService.findCommentsByPostid(postId);
        model.addAttribute("comVoLists",comVoLists);
        return "page-single-topic";
    }

    @PostMapping("/uploadComment")
    public String uploadComment(Comment comment,int userId){
        String commentString = JSON.toJSONString(comment);
        boolean bool = postFeignService.saveComment(commentString);
        System.out.println(bool);
        return "redirect:findPostById?postId="+comment.getPostId()+"&userId="+userId;
    }

    @PostMapping("/upadatePost")
    public boolean upadatePost(Post post){
        String postString = JSON.toJSONString(post);
        postFeignService.uploadPost(postString);
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

    @RequestMapping("/toIndex")
    public String toindex(){
        return "redirect:http://192.168.242.1:8013/index";
    }

}
