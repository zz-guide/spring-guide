package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBeanScope {

    @Test
    public void testBeanSingleton() {
        Logger logger = Logger.getLogger("testBeanSingleton");
        logger.log(Level.INFO, "测试<bean scope=\"singleton\">");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        Student student = (Student)ctx.getBean("student");
        Assertions.assertNotNull(student);
        logger.log(Level.INFO, "student 对象 地址: {0}", new Object[]{System.identityHashCode(student)});

        Student student1 = (Student)ctx.getBean("student");
        Assertions.assertNotNull(student1);
        logger.log(Level.INFO, "student1 对象 地址: {0}", new Object[]{System.identityHashCode(student1)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. scope 默认为 singleton, 即单例");
    }

    @Test
    public void testBeanPrototype() {
        Logger logger = Logger.getLogger("testBeanPrototype");
        logger.log(Level.INFO, "测试<bean scope=\"prototype\">");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        Student studentPrototype = (Student)ctx.getBean("studentPrototype");
        Assertions.assertNotNull(studentPrototype);
        logger.log(Level.INFO, "studentPrototype 对象 地址: {0}", new Object[]{System.identityHashCode(studentPrototype)});

        Student studentPrototype2 = (Student)ctx.getBean("studentPrototype");
        Assertions.assertNotNull(studentPrototype2);
        logger.log(Level.INFO, "studentPrototype2 对象 地址: {0}", new Object[]{System.identityHashCode(studentPrototype2)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. scope 值为 prototype, 每次new都是不同的对象");
    }
}
