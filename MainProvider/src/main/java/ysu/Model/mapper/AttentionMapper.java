package ysu.Model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ysu.Model.po.Attention;
import ysu.Model.po.AttentionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AttentionMapper {
    long countByExample(AttentionExample example);

    int deleteByExample(AttentionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionExample example);

    Attention selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}