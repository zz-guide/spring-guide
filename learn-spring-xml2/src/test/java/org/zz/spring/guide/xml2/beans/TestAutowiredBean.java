package org.zz.spring.guide.xml2.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml2.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml2.controller.UserController;
import org.zz.spring.guide.xml2.pojo.User;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAutowiredBean {

    @Test
    public void testFieldAutowiredInject() {
        Logger logger = Logger.getLogger("testFieldAutowiredInject");
        logger.log(Level.INFO, "测试各种方式注入，使用@Autowired");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        UserController userController = ctx.getBean(UserController.class);
        Assertions.assertNotNull(userController);
        logger.log(Level.INFO, "userController 对象 地址: {0}", new Object[]{System.identityHashCode(userController)});

        userController.add();

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. 被注解修饰的类可直接通过class对象获取一个bean实例");
        logger.log(Level.INFO, "2. 基于类属性的注入");
        logger.log(Level.INFO, "3. 基于set方法的注入");
        logger.log(Level.INFO, "4. 基于构造方法的注入");
        logger.log(Level.INFO, "5. 基于方法形参的注入");
        logger.log(Level.INFO, "6. 只有一个有参构造函数，无需注解可以自动注入");

    }
}
