package ysu.application.service;

import com.github.pagehelper.PageInfo;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;
import ysu.Model.po.Section;
import ysu.Model.po.SectionVo;

import java.util.List;

@FeignClient(value="MainProvider")
@Service
public interface IndexService {
    @RequestMapping(value = "getAll",method = RequestMethod.POST)
    public PageInfo getAll(@RequestParam(value = "pageNum")int num);
    @RequestMapping(value="getTop",method = RequestMethod.POST)
    public List<PostVo> getTop();
    @RequestMapping(value = "getVo",method =RequestMethod.POST,consumes = "application/json")
    public List<PostVo> getvo( @RequestParam("list") String list);

}