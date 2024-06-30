package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.TrainApp;

import java.util.List;


public interface TrainAppService {
    PageBean show(Integer page, Integer pageSize, String name);

    void delete(List<Integer> ids);

    void add(TrainApp trainApp);
}
