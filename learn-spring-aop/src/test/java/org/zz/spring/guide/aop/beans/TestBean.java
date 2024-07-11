package org.zz.spring.guide.aop.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.aop.TestApplicationContext;
import org.zz.spring.guide.xml.entity.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBean {

    @Test
    public void testBean() {
        Logger logger = Logger.getLogger("testBean");
        logger.log(Level.INFO, "获取一个最基础的student bean，先感受一下");

        ApplicationContext ctx = TestApplicationContext.getApplicationContext(TestApplicationContext.applicationContextXmlPaths);

        Student student = (Student)ctx.getBean("student");
        Assertions.assertNotNull(student);
        logger.log(Level.INFO, "student 对象 地址: {0}", new Object[]{System.identityHashCode(student)});

        logger.log(Level.INFO, "=== 结论 ===");
        logger.log(Level.INFO, "1. 默认调用无参构造");
        logger.log(Level.INFO, "2. 默认启动的时候就提前把对象初始化好了");
        logger.log(Level.INFO, "3. 默认对象是单例的，多次调用返回同一个对象");
    }
}
