package org.zz.spring.guide.annotation.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.zz.spring.guide.annotation.service.UserService;

@Controller
public class UserController {
    @Resource(name="userServiceImpl2")
    private UserService userService;

    public void add(){
        userService.addUserService();
    }
}
