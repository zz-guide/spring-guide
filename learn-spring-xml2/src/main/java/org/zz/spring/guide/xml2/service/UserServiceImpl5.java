package org.zz.spring.guide.xml2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.zz.spring.guide.xml2.dao.UserDao;

@Service
@Lazy
public class UserServiceImpl5 implements UserService {

    private UserDao userDao;

    // 只有一个有参数构造函数的时候，不需要加注解，也能注入
    public UserServiceImpl5(UserDao userDao) {
        System.out.println("=== UserServiceImpl5 只有一个有参构造，不需要加注解也能注入===");
        this.userDao = userDao;
    }


    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl5 addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
