package org.zz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("=== student 无参构造 ===");
    }

    public void init(){
        System.out.println("=== student init ===");
    }


    private void destroy(){
        System.out.println("=== student destroy ===");
    }
}
