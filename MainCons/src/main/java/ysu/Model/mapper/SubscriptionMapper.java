package ysu.Model.mapper;

import ysu.Model.po.Subscription;
import ysu.Model.po.SubscriptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubscriptionMapper {
    long countByExample(SubscriptionExample example);

    int deleteByExample(SubscriptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Subscription record);

    int insertSelective(Subscription record);

    List<Subscription> selectByExample(SubscriptionExample example);

    Subscription selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Subscription record, @Param("example") SubscriptionExample example);

    int updateByExample(@Param("record") Subscription record, @Param("example") SubscriptionExample example);

    int updateByPrimaryKeySelective(Subscription record);

    int updateByPrimaryKey(Subscription record);
}