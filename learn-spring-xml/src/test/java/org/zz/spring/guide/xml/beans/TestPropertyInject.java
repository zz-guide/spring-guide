package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.PropertyInjectPojo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPropertyInject {

    @Test
    public void testPropertyInject() {
        Logger logger = Logger.getLogger("testPropertyInject");
        logger.log(Level.INFO, "测试通过属性注入创建bean");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        PropertyInjectPojo propertyInjectPojo = (PropertyInjectPojo)ctx.getBean("propertyInjectPojo");
        Assertions.assertNotNull(propertyInjectPojo);
        logger.log(Level.INFO, "propertyInjectPojo 对象 地址: {0}", new Object[]{System.identityHashCode(propertyInjectPojo)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. property 注入， 本质上是通过调用对应属性的set方法实现注入");
        logger.log(Level.INFO, "2. 属性如果是对象或复杂类型，可通过ref引用其他定义好的bean标签");
    }

    @Test
    public void testPropertyInjectSimple() {
        Logger logger = Logger.getLogger("testPropertyInjectSimple");
        logger.log(Level.INFO, "测试通过属性注入创建bean，简写形式");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        PropertyInjectPojo propertyInjectPojo = (PropertyInjectPojo)ctx.getBean("propertyInjectPojoSimple");
        Assertions.assertNotNull(propertyInjectPojo);
        logger.log(Level.INFO, "propertyInjectPojoSimple 对象 地址: {0}", new Object[]{System.identityHashCode(propertyInjectPojo)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. property 注入简写形式，需要引入对应标签的命名空间");
    }
}
