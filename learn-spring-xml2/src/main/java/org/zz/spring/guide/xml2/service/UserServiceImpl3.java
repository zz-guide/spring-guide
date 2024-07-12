package org.zz.spring.guide.xml2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.zz.spring.guide.xml2.dao.UserDao;

@Service
@Lazy
public class UserServiceImpl3 implements UserService {

    private UserDao userDao;

    // 构造方法注入
    @Autowired
    public UserServiceImpl3(UserDao userDao) {
        System.out.println("=== UserServiceImpl3 构造函数注入===");
        this.userDao = userDao;
    }


    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl3 addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
