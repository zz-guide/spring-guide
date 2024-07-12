package org.zz.spring.guide.xml2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zz.spring.guide.xml2.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
