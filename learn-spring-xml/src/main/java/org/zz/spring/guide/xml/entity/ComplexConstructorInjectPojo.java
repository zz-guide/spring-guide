package org.zz.spring.guide.xml.entity;

import lombok.Data;

import java.util.*;

@Data
public class ComplexConstructorInjectPojo {
    private String[] arr;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private Properties properties;

    public ComplexConstructorInjectPojo() {
        System.out.println("=== ComplexConstructorInjectPojo 空构造函数 === ");
    }

    public ComplexConstructorInjectPojo(String[] arr, List<String> list, Map<String, String> map, Set<String> set, Properties properties) {
        System.out.println("=== ComplexConstructorInjectPojo 全部参数构造函数 === ");

        this.arr = arr;
        this.list = list;
        this.map = map;
        this.set = set;
        this.properties = properties;
    }
}
