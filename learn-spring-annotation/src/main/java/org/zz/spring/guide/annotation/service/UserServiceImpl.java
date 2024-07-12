package org.zz.spring.guide.annotation.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zz.spring.guide.annotation.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
