package cn.yd.springboot.service.impl;

import cn.yd.springboot.mapper.UserMapper;
import cn.yd.springboot.po.User;
import cn.yd.springboot.po.UserExample;
import cn.yd.springboot.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl  {


    @Autowired
    private UserMapper userMapper;

    /**
     * 判断用户的用户名与密码是否匹配
     * @param username
     * @return
     */
    public User isLogin(String username, String password) {

        UserExample userExample=new UserExample();
        userExample.setOrderByClause("Username asc");
        userExample.setDistinct(false);
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList=userMapper.selectByExample(userExample);
        if(userList.size()==0)return null;
        User user=userList.get(0);
        password= EncryptUtils.encodeMD5String(password);
        System.out.println(password);
        System.out.println(user.getPassword());
        if(password.equals(user.getPassword())){


            return user;
        }
        return null;
    }

    /**
     * 根据用户名判断该用户是否存在,没有就是false
     * @param username
     * @return
     */
    public boolean isHaveByUserName(String username){
        UserExample userExample=new UserExample();
        userExample.setOrderByClause("Username asc");
        userExample.setDistinct(false);
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList=userMapper.selectByExample(userExample);
        if(userList.size()==0)return false;
        return true;
    }

    /**
     * 判断email是否存在 没有解释false
     * @param email
     * @return
     */
    public boolean isHaveByEmail(String email){
        UserExample userExample=new UserExample();
        userExample.setOrderByClause("Email asc");
        userExample.setDistinct(false);
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(email);
        List<User> userList=userMapper.selectByExample(userExample);
        if(userList.size()==0)return false;
        return true;
    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int insert(User user){
        user.setPassword(EncryptUtils.encodeMD5String(user.getPassword()));
        return userMapper.insert(user);
    }





}
