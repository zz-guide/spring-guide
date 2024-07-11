package org.zz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teacher {
    private String name;
    private Integer age;
    private String message;
    private String[] arr;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private Properties properties;
}
