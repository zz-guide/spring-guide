package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.controller.UserController;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAutowired {

    @Test
    public void testAutowired() {
        Logger logger = Logger.getLogger("testAutowired");
        logger.log(Level.INFO, "测试自动装配  ");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        UserController userController = (UserController)ctx.getBean("userController");
        Assertions.assertNotNull(userController);
        logger.log(Level.INFO, "userController 对象 地址: {0}", new Object[]{System.identityHashCode(userController)});

        userController.addUser();

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. 实现复杂类型的自动装配");
    }
}
