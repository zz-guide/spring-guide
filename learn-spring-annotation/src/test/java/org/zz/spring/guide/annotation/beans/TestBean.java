package org.zz.spring.guide.annotation.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.annotation.TestAnnotationConfigApplicationContext;
import org.zz.spring.guide.annotation.controller.UserController;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBean {

    @Test
    public void testBean() {
        Logger logger = Logger.getLogger("testBean");
        logger.log(Level.INFO, "基于全注解获取bean");

        ApplicationContext ctx = TestAnnotationConfigApplicationContext.getApplicationContext();

        UserController userController = ctx.getBean(UserController.class);
        Assertions.assertNotNull(userController);
        logger.log(Level.INFO, "userController 对象 地址: {0}", new Object[]{System.identityHashCode(userController)});

        logger.log(Level.INFO, "=== 结论 ===");
    }
}
