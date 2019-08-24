package cn.yd.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.Model.mapper.LabelMapper;
import ysu.Model.mapper.PostMapper;
import ysu.Model.mapper.SectionMapper;
import ysu.Model.mapper.UserMapper;
import ysu.Model.po.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionMapper sectionMapper;
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    public List<SectionVo> getSectionVo()
    {
        SectionExample sectionExample=new SectionExample();
        List<Section> sectionList=sectionMapper.selectByExample(sectionExample);
        List<SectionVo> sectionVoList=new ArrayList<SectionVo>();
        for (Section section : sectionList)
        {
            LabelExample labelExample=new LabelExample();
            LabelExample.Criteria criteria=labelExample.createCriteria();
            int count=section.getId();
            count=0-count;
            System.out.println(count);
            criteria.andPostIdEqualTo(count);
            SectionVo sectionVo=new SectionVo();
            sectionVo.setLabelList(labelMapper.selectByExample(labelExample));
            sectionVo.setSection(section);
            sectionVoList.add(sectionVo);

        }
        for (SectionVo sectionVo : sectionVoList) {
            System.out.println(sectionVo.getSection().getSectionName());
        }
        return sectionVoList;
    }

    public PageInfo<Post> getSectionPageInfo(int pageNum,int sectionid)
    {
        PageHelper.startPage(pageNum,5);
        PostExample example=new PostExample();
        PostExample.Criteria criteria=example.createCriteria();
        criteria.andTypeNotEqualTo("-1");
        criteria.andSectionIdEqualTo(sectionid);
        List<Post> list= postMapper.selectByExample(example);
        PageInfo<Post> pageInfo=new PageInfo<Post>(list);
        System.out.println(pageInfo);
        return pageInfo;

    }

    public List<PostVo> getSectionPostVo(List<Post> list)
    {
        List<PostVo> listvo=new ArrayList<PostVo>();
        for (Post post : list) {
            PostVo vo = new PostVo();
            vo.setPost(post);
            User user=userMapper.selectByPrimaryKey(post.getUserId());
            vo.setUser(user);
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

    public List<PostVo> getSectionTop(int sectionid)
    {
        PostExample example=new PostExample();
        PostExample.Criteria criteria=example.createCriteria();
        criteria.andTypeNotEqualTo("-1");
        criteria.andIsTopEqualTo(1);
        criteria.andSectionIdEqualTo(sectionid);

        List<Post> list=postMapper.selectByExample(example);
        List<PostVo> listvo=this.getSectionPostVo(list);
        System.out.println(listvo);
        return listvo;
    }

}
