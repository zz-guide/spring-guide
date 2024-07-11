package org.zz.spring.guide.aop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestApplicationContext {
    public static final String[] applicationContextXmlPaths = {"applicationContext.xml"};

    public static ApplicationContext getApplicationContext(String[] paths) {
        return new ClassPathXmlApplicationContext(paths);
    }

    @Test
    public void testCreateApplicationContext() {
        Logger logger = Logger.getLogger("testCreateApplicationContext");

        ApplicationContext applicationContext = getApplicationContext(applicationContextXmlPaths);
        Assertions.assertNotNull(applicationContext);

        logger.log(Level.INFO, "测试创建 ClassPathXmlApplicationContext 对象");
    }

}
