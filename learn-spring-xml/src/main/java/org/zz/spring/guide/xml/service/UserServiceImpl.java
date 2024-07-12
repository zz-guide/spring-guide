package org.zz.spring.guide.xml.service;

import org.zz.spring.guide.xml.dao.UserDao;
import org.zz.spring.guide.xml.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        System.out.println("UserServiceImpl setUserDao()方法执行了");
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
