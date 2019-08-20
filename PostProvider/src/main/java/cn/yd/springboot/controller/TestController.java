package cn.yd.springboot.controller;

import cn.yd.springboot.po.Section;
import cn.yd.springboot.po.User;
import cn.yd.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id) throws Exception {

        return testService.findUserById(id);
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers() throws Exception {

        return testService.findAllUsers();
    }

}
