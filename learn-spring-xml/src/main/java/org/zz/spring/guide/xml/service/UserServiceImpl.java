package org.zz.spring.guide.xml.service;

import org.zz.spring.guide.xml.dao.UserDao;

public class UserServiceImpl implements UserService {

    // 构造函数
    public UserServiceImpl() {
        System.out.println("=== UserServiceImpl 无参构造 ===");
    }

    public UserServiceImpl(UserDao demoDao) {
        System.out.println("基于构造器的注入：" + demoDao);
    }

    public UserServiceImpl(String str) {
        System.out.println("基于构造器的注入(字符串)：" + str);
    }
    public UserServiceImpl(String str, int age) {
        System.out.println("基于构造器的注入(多参数)：" + str+",age="+age);
    }

    // setXXX方式注入
    public void setUserDao(UserDao demoDao) {
        System.out.println("set方法注入，setDemoDao:" + demoDao);
    }
    public void setName(String name) {
        System.out.println("set方法注入，setName:" + name);
    }

    // 测试从properties文件注入
    public void setUsername(String username) {
        System.out.println("set方法注入，username:" + username);
    }

}
