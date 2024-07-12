package org.zz.spring.guide.xml2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.zz.spring.guide.xml2.dao.UserDao;

@Service
@Lazy
public class UserServiceImpl4 implements UserService {

    private UserDao userDao;

    // 形参注入
    public UserServiceImpl4(@Autowired UserDao userDao) {
        System.out.println("=== UserServiceImpl4 构造函数 形参注入===");
        this.userDao = userDao;
    }


    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl4 addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
