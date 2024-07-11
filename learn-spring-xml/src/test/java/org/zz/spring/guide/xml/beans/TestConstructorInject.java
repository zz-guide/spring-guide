package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.ComplexConstructorInjectPojo;
import org.zz.spring.guide.xml.entity.ConstructorInjectPojo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConstructorInject {

    @Test
    public void testConstructorInject() {
        Logger logger = Logger.getLogger("testConstructorInject");
        logger.log(Level.INFO, "测试通过构造函数注入创建bean");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        ConstructorInjectPojo constructorInjectPojo = (ConstructorInjectPojo)ctx.getBean("constructorInjectPojo");
        Assertions.assertNotNull(constructorInjectPojo);
        logger.log(Level.INFO, "constructorInjectPojo 对象: {0}", new Object[]{constructorInjectPojo});
        logger.log(Level.INFO, "constructorInjectPojo 对象 地址: {0}", new Object[]{System.identityHashCode(constructorInjectPojo)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. constructor() 注入，属性全部通过构造器进行设置");
    }

    @Test
    public void testComplexConstructorInject() {
        Logger logger = Logger.getLogger("testComplexConstructorInject");
        logger.log(Level.INFO, "测试通过构造函数注入复杂属性，创建bean");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        ComplexConstructorInjectPojo complexConstructorInjectPojo = (ComplexConstructorInjectPojo)ctx.getBean("complexConstructorInjectPojo");
        Assertions.assertNotNull(complexConstructorInjectPojo);
        logger.log(Level.INFO, "complexConstructorInjectPojo 对象: {0}", new Object[]{complexConstructorInjectPojo});
        logger.log(Level.INFO, "complexConstructorInjectPojo 对象 地址: {0}", new Object[]{System.identityHashCode(complexConstructorInjectPojo)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. constructor() 注入，支持array，map,set,list，Properties 等");
    }
}
