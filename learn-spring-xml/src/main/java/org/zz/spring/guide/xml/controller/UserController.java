package org.zz.spring.guide.xml.controller;

import org.zz.spring.guide.xml.service.UserService;
import org.zz.spring.guide.xml.service.UserServiceImpl;

public class UserController {
    private UserService userService;
    public void setUserService(UserService userService) {
        System.out.println("UserController setUserService()方法执行了");
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("UserController addUser()方法 执行了");
        userService.addUserService();
    }

}
