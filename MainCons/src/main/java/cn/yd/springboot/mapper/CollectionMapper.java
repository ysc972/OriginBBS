package cn.yd.springboot.mapper;

import cn.yd.springboot.po.Collection;
import cn.yd.springboot.po.CollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    long countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}