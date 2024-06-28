package com.haoqi.hqedu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer id;
    private String name;
    private Integer salary;
    private Integer age;
    private Integer sex;
}
