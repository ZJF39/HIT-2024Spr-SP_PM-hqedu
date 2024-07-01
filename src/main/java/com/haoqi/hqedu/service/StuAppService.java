package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.StuApp;

import java.util.List;

public interface StuAppService {
    PageBean show(Integer page, Integer pageSize, String stuName);

    void delete(List<Integer> ids);

    void add(StuApp stuApp);

    void update(StuApp stuApp);
}
