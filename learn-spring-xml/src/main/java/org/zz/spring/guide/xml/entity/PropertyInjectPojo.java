package org.zz.spring.guide.xml.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropertyInjectPojo {
    private String name;
    private Integer age;
    private ExtPojo extPojo;

    public void setName(String name) {
        System.out.println("=== PropertyInjectPojo setName ==="+name);
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("=== PropertyInjectPojo setAge ==="+age);
        this.age = age;
    }

    public void setExtPojo(ExtPojo extPojo) {
        System.out.println("=== PropertyInjectPojo setExtPojo ==="+extPojo);
        this.extPojo = extPojo;
    }
}
