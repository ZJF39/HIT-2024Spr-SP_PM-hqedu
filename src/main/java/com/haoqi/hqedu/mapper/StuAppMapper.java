package com.haoqi.hqedu.mapper;

import com.haoqi.hqedu.pojo.StuApp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuAppMapper {


    List<StuApp> show(String stuName);

    void delete(List<Integer> ids);

    void add(StuApp stuApp);

    void update(StuApp stuApp);
}
