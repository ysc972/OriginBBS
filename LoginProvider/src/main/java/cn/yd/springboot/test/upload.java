package cn.yd.springboot.test;

import cn.yd.springboot.fastdfs.FastDFSClient;
import cn.yd.springboot.fastdfs.FastDFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.NonWritableChannelException;

@Controller
public class upload {


    @RequestMapping("/test")
    public String upload(){return "test";}


    @RequestMapping("/upload")
    public String uo(MultipartFile file) throws Exception {
        FastDFSClient Client = new FastDFSClient("classpath:tracker.conf");
        boolean fileis=file.isEmpty();
        String Newname=Client.uploadFile(file.getBytes());
        System.out.println(Newname);






        return "null";

    }






}


