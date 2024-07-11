package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBeanLifeCycle {

    @Test
    public void testBeanLazyInit() {
        Logger logger = Logger.getLogger("testBeanLazyInit");
        logger.log(Level.INFO, "测试<bean lazy-init>");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);
        logger.log(Level.INFO, "增加lazy-init=true之后，发现 Student 的 无参构造函数还未执行");

        Student student = (Student)ctx.getBean("studentLifeCycle");
        Assertions.assertNotNull(student);
        logger.log(Level.INFO, "student 对象 地址: {0}", new Object[]{System.identityHashCode(student)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. <bean lazy-init=\"true\"> lazy-init 可保证bean在首次使用的时候才初始化");
    }

    @Test
    public void testBeansDefaultLazyInit() {
        Logger logger = Logger.getLogger("testBeansDefaultLazyInit");
        logger.log(Level.INFO, "测试<beans default-lazy-init>");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);
        logger.log(Level.INFO, "增加default-lazy-init=true之后，发现 Student 的 无参构造函数还未执行");

        Student studentLifeCycle2 = (Student)ctx.getBean("studentLifeCycle2");
        Assertions.assertNotNull(studentLifeCycle2);
        logger.log(Level.INFO, "studentLifeCycle2 对象 地址: {0}", new Object[]{System.identityHashCode(studentLifeCycle2)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. <beans default-lazy-init=\"true\"> default-lazy-init 优先级较 lazy-init 低，用来兜底");
    }

    @Test
    public void testBeanInitMethod() {
        Logger logger = Logger.getLogger("testBeanInitMethod");
        logger.log(Level.INFO, "测试<bean init-method>");


        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        Student studentLifeCycle1 = (Student)ctx.getBean("studentLifeCycle1");
        Assertions.assertNotNull(studentLifeCycle1);
        logger.log(Level.INFO, "studentLifeCycle1 对象 地址: {0}", new Object[]{System.identityHashCode(studentLifeCycle1)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. <bean init-method=\"init\"> init-method 用来定义bean对象的初始化方法，先执行构造方法，后执行该方法，如果定义了");
    }

    @Test
    public void testBeanDestroyMethod() {
        Logger logger = Logger.getLogger("testBeanDestroyMethod");
        logger.log(Level.INFO, "测试<bean destroy-method>");

        ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        Student studentLifeCycle1 = (Student)ctx.getBean("studentLifeCycle1");
        Assertions.assertNotNull(studentLifeCycle1);
        logger.log(Level.INFO, "studentLifeCycle1 对象 地址: {0}", new Object[]{System.identityHashCode(studentLifeCycle1)});

        ctx.close(); // ConfigurableApplicationContext 对象有close方法，可以模拟关闭容器
        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. <bean destroy-method=\"init\"> destroy-method bean对象销毁时会调用");
    }
}
