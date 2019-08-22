package ysu.application.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ysu.Model.mapper.LabelMapper;
import ysu.Model.mapper.PostMapper;
import ysu.Model.mapper.SectionMapper;
import ysu.Model.po.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {
   @Autowired
    private  PostMapper postMapper;
    @Autowired
   private LabelMapper labelMapper;
    @Autowired
   private SectionMapper sectionMapper;

    public PageInfo getAll(int pagenum)
    {
        PageHelper.startPage(pagenum,5);
        PostExample example=new PostExample();
        PostExample.Criteria criteria=example.createCriteria();
        criteria.andTypeNotEqualTo("-1");
        List<Post> list=postMapper.selectByExample(example);
        PageInfo<Post> pageInfo=new PageInfo<Post>(list);

        System.out.println(pageInfo);
        return pageInfo;
    }

    public List<PostVo> getTop()
    {
        PostExample example=new PostExample();
        PostExample.Criteria criteria=example.createCriteria();
        criteria.andTypeNotEqualTo("-1");
        criteria.andIsTopEqualTo(1);
        List<Post> list=postMapper.selectByExample(example);
        List<PostVo> listvo=new ArrayList<>();

        for (Post post : list) {
            PostVo vo = new PostVo();
            vo.setPost(post);
            LabelExample labelExample = new LabelExample();
            LabelExample.Criteria criteria1= labelExample.createCriteria();
            criteria1.andPostIdEqualTo(post.getId());
            vo.setLabelList(labelMapper.selectByExample(labelExample));
            vo.setSection(sectionMapper.selectByPrimaryKey(post.getSectionId()));
            listvo.add(vo);
        }




        System.out.println(listvo);
        return listvo;
    }

    public List<PostVo> getVo(List<Post> list)
    {
        List<PostVo> listvo=new ArrayList<PostVo>();
            for (Post post : list) {
                PostVo vo = new PostVo();
            vo.setPost(post);
            LabelExample labelExample = new LabelExample();
            LabelExample.Criteria criteria1= labelExample.createCriteria();
            criteria1.andPostIdEqualTo(post.getId());
            vo.setLabelList(labelMapper.selectByExample(labelExample));
            vo.setSection(sectionMapper.selectByPrimaryKey(post.getSectionId()));
            listvo.add(vo);
        }
        System.out.println(listvo);
        return listvo;
    }

}
