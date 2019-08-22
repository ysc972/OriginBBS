package ysu.application.service;

import com.github.pagehelper.PageInfo;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;
import ysu.Model.po.SectionVo;

import java.util.List;
@FeignClient(value="MainProvider")
@Service
public interface SectionService {
    @RequestMapping(value = "getSectionVo",method = RequestMethod.POST)
    public List<SectionVo> getSectionVo();
    @RequestMapping(value="getSectionPageInfo",method = RequestMethod.POST)
    public PageInfo<Post> getSectionPageInfo( @RequestParam(value = "pageNum") int pageNum,@RequestParam("sectionId") int sectionId);
    @RequestMapping(value = "getSectionPostVo",method = RequestMethod.POST)
    public List<PostVo> getSectionPostVo(@RequestParam("list") String list);
    @RequestMapping(value="getSectionTop",method = RequestMethod.POST)
    public List<PostVo> getSectionTop(@RequestParam("sectionId") int sectionId);
}
