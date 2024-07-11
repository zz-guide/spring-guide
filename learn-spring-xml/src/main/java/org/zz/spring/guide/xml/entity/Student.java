package org.zz.spring.guide.xml.entity;

public class Student {
    private Long id;
    private String name;
    private Integer age;

    public Student() {
        System.out.println("=== student 无参构造 ===");
    }

    public Student(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("=== student 全部参数构造 ===");
    }

    public void init() {
        System.out.println("=== student init() ===");
    }


    private void destroy() {
        System.out.println("=== student destroy() ===");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
