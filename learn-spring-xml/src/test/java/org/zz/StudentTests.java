package org.zz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zz.entity.Student;

public class StudentTests {

    public ApplicationContext getApplicationContext() {
        String[] path = {"applicationContext.xml"};
        return new ClassPathXmlApplicationContext(path);
    }

    /**
     * 加载 applicationContext.xml
     */
    @Test
    public void testApplicationContext() {
        System.out.println(getApplicationContext());
    }

    @Test
    public void testBeanFactory(){
        String[] path = {"applicationContext.xml"};
        // 创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 通过bean工厂创建一个读取xml文件的对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        // 读取xml文件
        xmlBeanDefinitionReader.loadBeanDefinitions(path);
        // 根据id或者name获取bean对象
        Student student = (Student)beanFactory.getBean("student");
        System.out.println(student);
    }

    @Test
    public void testBean() {
        ApplicationContext ctx = getApplicationContext();
        // bean name 可以配置多个别名
        Student stu1 = (Student)ctx.getBean("student");
        Student stu2 = (Student)ctx.getBean("studentAlias");
        Student stu3 = (Student)ctx.getBean("studentAlias2");
        System.out.println(System.identityHashCode(stu1));
        System.out.println(System.identityHashCode(stu2));
        System.out.println(System.identityHashCode(stu3));
    }

    @Test
    public void testBeanAlias() {
        ApplicationContext ctx = getApplicationContext();
        // 这里bean的名字就是xml中配置的名字
        Student stu1 = (Student)ctx.getBean("student");
        Student stu2 = (Student)ctx.getBean("student");
        // 默认情况下 bean 是单例的
        System.out.println(System.identityHashCode(stu1));
        System.out.println(System.identityHashCode(stu2));
    }
}
