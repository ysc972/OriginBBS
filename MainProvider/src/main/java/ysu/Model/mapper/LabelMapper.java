package ysu.Model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ysu.Model.po.Label;
import ysu.Model.po.LabelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LabelMapper {
    long countByExample(LabelExample example);

    int deleteByExample(LabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    List<Label> selectByExample(LabelExample example);

    Label selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}