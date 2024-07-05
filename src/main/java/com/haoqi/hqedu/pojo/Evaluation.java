package com.haoqi.hqedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    private int id;
    private String stuName;
    private String courseName;
    private String eva;
    private int rating;
}
