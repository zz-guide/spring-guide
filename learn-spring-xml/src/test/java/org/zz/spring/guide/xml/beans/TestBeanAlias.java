package org.zz.spring.guide.xml.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.xml.TestClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBeanAlias {

    @Test
    public void testBeanAlias() {
        Logger logger = Logger.getLogger("testBeanAlias");
        logger.log(Level.INFO, "测试bean别名， <bean name>或者<alias name alias>");

        ApplicationContext ctx = TestClassPathXmlApplicationContext.getApplicationContext(TestClassPathXmlApplicationContext.applicationContextXmlPaths);

        Student student = (Student)ctx.getBean("student");
        Assertions.assertNotNull(student);
        logger.log(Level.INFO, "student 对象 地址: {0}", new Object[]{System.identityHashCode(student)});

        Student studentAlias1 = (Student)ctx.getBean("studentAlias1");
        Assertions.assertNotNull(studentAlias1);
        logger.log(Level.INFO, "studentAlias1 对象 地址: {0}", new Object[]{System.identityHashCode(studentAlias1)});

        Student studentAlias2 = (Student)ctx.getBean("studentAlias2");
        Assertions.assertNotNull(studentAlias2);
        logger.log(Level.INFO, "studentAlias2 对象 地址: {0}", new Object[]{System.identityHashCode(studentAlias2)});


        Student studentAlias3 = (Student)ctx.getBean("studentAlias3");
        Assertions.assertNotNull(studentAlias3);
        logger.log(Level.INFO, "<alias> 标签 studentAlias3 对象 地址: {0}", new Object[]{System.identityHashCode(studentAlias3)});

        Student studentAlias4 = (Student)ctx.getBean("studentAlias4");
        Assertions.assertNotNull(studentAlias4);
        logger.log(Level.INFO, "<alias> 标签 studentAlias4 对象 地址: {0}", new Object[]{System.identityHashCode(studentAlias4)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. 可通过<bean> 标签的 name属性定义别名，逗号隔开，支持多个");
        logger.log(Level.INFO, "2. 可通过<alias> 标签的 alias属性定义别名，一个别名一个标签");
    }
}
