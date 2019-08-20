package cn.yd.springboot.service;

import cn.yd.springboot.po.User;

import java.util.List;

public interface TestService {
    List<User> findAllUsers() throws Exception;
    User findUserById(int id) throws Exception;
}
