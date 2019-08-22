package ysu.application.Contraller;

import com.github.pagehelper.PageInfo;
import feign.Headers;
import javafx.geometry.Pos;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ysu.Model.po.Post;
import ysu.Model.po.PostVo;
import ysu.application.service.IndexService;
import com.alibaba.fastjson.JSON;
import java.util.List;

@RestController
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping(value="getAll",method = RequestMethod.POST)

    public PageInfo getAll(@RequestParam(value = "pageNum") int num)
    {

        return indexService.getAll(num);

    }
    @RequestMapping(value = "getTop",method = RequestMethod.POST)
    public List<PostVo> getTop()
    {
        return indexService.getTop();
    }

    @RequestMapping(value = "getVo",method = RequestMethod.POST)
    public List<PostVo> getVo(@RequestParam("list") String list)
    {
        System.out.println(1);

        List<Post> listpost=JSON.parseArray(list,Post.class);
        return indexService.getVo(listpost);
    }
}
