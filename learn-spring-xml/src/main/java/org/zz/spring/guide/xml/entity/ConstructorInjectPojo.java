package org.zz.spring.guide.xml.entity;

import lombok.Data;
@Data
public class ConstructorInjectPojo {
    private String name;
    private Integer age;

    public ConstructorInjectPojo(){
        System.out.println("=== ConstructorInjectPojo 空构造函数 === ");
    }

    public ConstructorInjectPojo(String name, Integer age){
        System.out.println("=== ConstructorInjectPojo 全部参数构造函数 === ");
        this.name = name;
        this.age = age;
    }
}
