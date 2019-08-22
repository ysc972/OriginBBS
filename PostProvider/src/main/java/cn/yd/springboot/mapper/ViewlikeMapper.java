package cn.yd.springboot.mapper;

import cn.yd.springboot.po.Viewlike;
import cn.yd.springboot.po.ViewlikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewlikeMapper {
    long countByExample(ViewlikeExample example);

    int deleteByExample(ViewlikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Viewlike record);

    int insertSelective(Viewlike record);

    List<Viewlike> selectByExample(ViewlikeExample example);

    Viewlike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Viewlike record, @Param("example") ViewlikeExample example);

    int updateByExample(@Param("record") Viewlike record, @Param("example") ViewlikeExample example);

    int updateByPrimaryKeySelective(Viewlike record);

    int updateByPrimaryKey(Viewlike record);
}