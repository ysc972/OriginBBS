package ysu.application.Contraller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;
import ysu.Model.po.SectionVo;
import ysu.application.service.IndexService;
import ysu.application.service.SectionService;

import java.util.List;

@Controller
public class CategoriesController {
    @Autowired
    private SectionService sectionService;
    @RequestMapping("/section")
    public String getCategories(Model model)
    {
        List<SectionVo> list=sectionService.getSectionVo();
        System.out.println(list);
        model.addAttribute("SectionVoList",list);
        return "page-categories";
    }
    @RequestMapping("getSectionPost")
    public String GetSectionPost(Model model,@RequestParam("sectionId") int sectionid,@RequestParam(defaultValue = "1",value ="pageNum")int pageNum)
    {
      PageInfo<Post> pageInfo =sectionService.getSectionPageInfo(pageNum,sectionid);
      SectionVo sectionVo=null;
      List<SectionVo> sectionVoList=sectionService.getSectionVo();
        for (SectionVo vo : sectionVoList) {
            if(vo.getSection().getId()==sectionid)
            {
                sectionVo=vo;
                break;
            }
        }
      String list= JSON.toJSONString((List<Post>)pageInfo.getList());
      List<PostVo> postVoList=sectionService.getSectionPostVo(list);
      List<PostVo> toplist=sectionService.getSectionTop(sectionid);
        System.out.println(postVoList.size());
        model.addAttribute("sectionVo",sectionVo);
        model.addAttribute("TopList",toplist);
        model.addAttribute("PostVolist",postVoList);
        model.addAttribute("pageInfo",pageInfo);
        return "page-categories-single";
    }


}
