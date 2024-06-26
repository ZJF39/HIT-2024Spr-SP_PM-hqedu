package com.haoqi.hqedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stu {
    private int id;
    private String username;
    private String password;
    private String name;
    private String telNum;
}
