package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.Evaluation;
import com.haoqi.hqedu.pojo.PageBean;

import java.util.List;

public interface EvaService {

    PageBean show(Integer page, Integer pageSize, String stuName, String courseName);

    void insert(Evaluation evaluation);

    void delete(List<Integer> ids);
}
