package cn.yd.springboot.mapper;

import cn.yd.springboot.po.Banned;
import cn.yd.springboot.po.BannedExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannedMapper {
    long countByExample(BannedExample example);

    int deleteByExample(BannedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banned record);

    int insertSelective(Banned record);

    List<Banned> selectByExample(BannedExample example);

    Banned selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Banned record, @Param("example") BannedExample example);

    int updateByExample(@Param("record") Banned record, @Param("example") BannedExample example);

    int updateByPrimaryKeySelective(Banned record);

    int updateByPrimaryKey(Banned record);
}