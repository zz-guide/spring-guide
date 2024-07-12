package org.zz.spring.guide.annotation.aop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zz.spring.guide.annotation.aop.config.ApplicationContextConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAnnotationConfigApplicationContext {
    // 加载配置类
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
