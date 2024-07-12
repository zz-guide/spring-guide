package org.zz.spring.guide.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void addUserDao() {
        System.out.println("UserDaoImpl addUserDao() 执行了");
    }
}
