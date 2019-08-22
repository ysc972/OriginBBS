package ysu.Model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ysu.Model.po.Role;
import ysu.Model.po.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}