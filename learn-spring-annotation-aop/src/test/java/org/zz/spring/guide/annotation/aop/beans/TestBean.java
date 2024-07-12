package org.zz.spring.guide.annotation.aop.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.zz.spring.guide.annotation.aop.TestAnnotationConfigApplicationContext;
import org.zz.spring.guide.annotation.aop.service.Calculator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBean {

    @Test
    public void testBean() {
        Logger logger = Logger.getLogger("testBean");
        logger.log(Level.INFO, "基于计算器计算方法，添加一个log 切面");

        ApplicationContext ctx = TestAnnotationConfigApplicationContext.getApplicationContext();

        Calculator calculator = ctx.getBean("calculatorImpl", Calculator.class);
        Assertions.assertNotNull(calculator);
        logger.log(Level.INFO, "calculator 对象 地址: {0}", new Object[]{System.identityHashCode(calculator)});

        calculator.add(1, 2);

        logger.log(Level.INFO, "=== 结论 ===");
    }
}
