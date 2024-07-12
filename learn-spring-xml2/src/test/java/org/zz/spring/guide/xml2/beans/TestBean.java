package org.zz.spring.guide.xml2.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml2.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml2.pojo.User;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBean {

    @Test
    public void testBean() {
        Logger logger = Logger.getLogger("testBean");
        logger.log(Level.INFO, "基于注解获取bean");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        User user = ctx.getBean("user", User.class);
        Assertions.assertNotNull(user);
        logger.log(Level.INFO, "user 对象 地址: {0}", new Object[]{System.identityHashCode(user)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. 默认调用无参构造");
        logger.log(Level.INFO, "2. 默认启动的时候就提前把对象初始化好了");
        logger.log(Level.INFO, "3. 默认对象是单例的，多次调用返回同一个对象");
    }
}
