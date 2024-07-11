package org.zz;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zz.entity.Student;
import org.zz.entity.Teacher;

public class TeacherTests {

    public ApplicationContext getApplicationContext() {
        String[] path = {"applicationContext.xml"};
        return new ClassPathXmlApplicationContext(path);
    }

    @Test
    public void testPropertyInject() {
        ApplicationContext ctx = getApplicationContext();
        Teacher teacher = (Teacher)ctx.getBean("teacher");
        System.out.println(teacher);
        System.out.println(System.identityHashCode(teacher));
    }

    @Test
    public void testConstructorInject() {
        ApplicationContext ctx = getApplicationContext();
        Teacher teacher = (Teacher)ctx.getBean("teacherConstructor");
        System.out.println(teacher);
        System.out.println(System.identityHashCode(teacher));
    }
}
