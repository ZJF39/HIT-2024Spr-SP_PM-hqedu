package com.haoqi.hqedu.mapper;

import com.haoqi.hqedu.pojo.TrainApp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrainAppMapper {


    List<TrainApp> show(String name);

    void delete(List<Integer> ids);

    void add(TrainApp trainApp);
}
