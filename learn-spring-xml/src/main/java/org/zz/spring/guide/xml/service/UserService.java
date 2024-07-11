package org.zz.spring.guide.xml.service;

import org.zz.spring.guide.xml.dao.UserDao;

public interface UserService {
    void setUserDao(UserDao userDao);
}
