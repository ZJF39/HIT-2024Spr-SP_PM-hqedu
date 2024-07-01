package com.haoqi.hqedu.pojo;
//报名申请

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuApp {

    private Integer id;
    private String stuName;
    private String courseName;
    private Integer flag;
}
