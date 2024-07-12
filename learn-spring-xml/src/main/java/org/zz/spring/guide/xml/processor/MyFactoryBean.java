package org.zz.spring.guide.xml.processor;

import org.springframework.beans.factory.FactoryBean;
import org.zz.spring.guide.xml.entity.Student;

public class MyFactoryBean implements FactoryBean<Student> {

    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
