package cn.yd.springboot.Contraller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;
import ysu.Model.po.SectionVo;
import cn.yd.springboot.service.SectionService;

import java.util.List;

@RestController
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = "getSectionVo",method = RequestMethod.POST)
    public List<SectionVo> getSectionVo()
    {
        return sectionService.getSectionVo();

    }
    @RequestMapping(value = "getSectionPageInfo",method = RequestMethod.POST)
    public PageInfo<Post> getSectionPageInfo(@RequestParam("pageNum") int pageNum,@RequestParam("sectionId") int sectionid)
    {
        return sectionService.getSectionPageInfo(pageNum,sectionid);
    }
    @RequestMapping(value = "getSectionPostVo",method = RequestMethod.POST)
    public List<PostVo> getSectiolnPostVo(@RequestParam("list") String list)
    {
        List<Post> postList=JSON.parseArray(list,Post.class);
        return sectionService.getSectionPostVo(postList);
    }
    @RequestMapping(value = "getSectionTop",method = RequestMethod.POST )
    public List<PostVo> getSectionTop(@RequestParam("sectionId")int sectionid)
    {
        return sectionService.getSectionTop(sectionid);
    }


}
