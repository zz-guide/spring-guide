package org.zz.spring.guide.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zz.spring.guide.xml.entity.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClassPathXmlApplicationContext {
    public static final String[] applicationContextXmlPaths = {"applicationContext.xml"};

    public static ApplicationContext getApplicationContext(String[] paths) {
        return new ClassPathXmlApplicationContext(paths);
    }

    @Test
    public void testCreateApplicationContext() {
        Logger logger = Logger.getLogger("testCreateApplicationContext");

        ApplicationContext applicationContext = getApplicationContext(applicationContextXmlPaths);
        Assertions.assertNotNull(applicationContext);

        logger.log(Level.INFO, "测试创建 ClassPathXmlApplicationContext 对象");
    }

    @Test
    public void testCreateConfigurableApplicationContext() {
        Logger logger = Logger.getLogger("testCreateConfigurableApplicationContext");

        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)getApplicationContext(applicationContextXmlPaths);
        Assertions.assertNotNull(configurableApplicationContext);

        logger.log(Level.INFO, "测试创建 configurableApplicationContext 对象");
    }

    @Test
    public void testBeanFactory() {
        Logger logger = Logger.getLogger("testBeanFactory");

        // 创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 通过bean工厂创建一个读取xml文件的对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        // 读取xml文件
        xmlBeanDefinitionReader.loadBeanDefinitions(applicationContextXmlPaths);

        // 根据id或者name获取bean对象
        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student);

        logger.log(Level.INFO, "测试通过 BeanFactory 创建 bean 对象");
    }
}
