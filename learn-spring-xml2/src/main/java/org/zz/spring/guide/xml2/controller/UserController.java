package org.zz.spring.guide.xml2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.zz.spring.guide.xml2.service.UserService;

@Controller
public class UserController {
    // 属性注入， @Autowired根据类型自动注入
    @Autowired
    @Qualifier("userServiceImpl5")
    private UserService userService;

    public void add(){
        userService.addUserService();
    }
}
