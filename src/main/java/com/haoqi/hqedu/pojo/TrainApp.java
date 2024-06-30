package com.haoqi.hqedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainApp {
    private Integer id;
    private String trainappName;
    private String companyName;
    private Date startDate;
    private Date endDate;
}