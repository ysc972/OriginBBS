package ysu.Model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ysu.Model.po.Message;
import ysu.Model.po.MessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}