package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestFactoryBean {

    @Test
    public void testFactoryBean() {
        Logger logger = Logger.getLogger("testFactoryBean");
        logger.log(Level.INFO, "通过自定义类实现FactoryBean接口，实现一个bean");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        Student student = (Student)ctx.getBean("factoryBean");
        Assertions.assertNotNull(student);
        logger.log(Level.INFO, "student 对象 地址: {0}", new Object[]{System.identityHashCode(student)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. 自定义类实现FactoryBean interface");
    }
}
