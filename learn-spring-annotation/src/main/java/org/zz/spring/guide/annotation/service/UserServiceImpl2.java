package org.zz.spring.guide.annotation.service;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.zz.spring.guide.annotation.dao.UserDao;

@Service
@Lazy
public class UserServiceImpl2 implements UserService {

    private UserDao userDao;

    // @Autowired 用在set方法上进行注入
    @Resource
    public void setUserDao(UserDao userDao) {
        System.out.println("=== UserServiceImpl2 setUserDao方法注入===");
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserServiceImpl2 addUserService() 方法执行了");
        userDao.addUserDao();
    }
}
