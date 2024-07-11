package org.zz.spring.guide.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.annotation.config.ApplicationContextConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAnnotationConfigApplicationContext {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Test
    public void testAnnotationConfigApplicationContext() {
        Logger logger = Logger.getLogger("testAnnotationConfigApplicationContext");

        Assertions.assertNotNull(context);

        logger.log(Level.INFO, "测试创建 AnnotationConfigApplicationContext 对象");
    }
}
