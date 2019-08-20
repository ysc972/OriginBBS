package cn.yd.springboot.service.impl;

import cn.yd.springboot.mapper.UserMapper;
import cn.yd.springboot.po.User;
import cn.yd.springboot.po.UserExample;
import cn.yd.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() throws Exception {

        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);

        return users;
    }

    @Override
    public User findUserById(int id) throws Exception {

        return userMapper.selectByPrimaryKey(1);
    }
}
