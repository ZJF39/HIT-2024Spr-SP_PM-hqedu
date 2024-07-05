package com.haoqi.hqedu.mapper;

import com.haoqi.hqedu.pojo.Evaluation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaMapper {
    List<Evaluation> show(String stuName, String courseName);

    void insert(Evaluation evaluation);

    void delete(List<Integer> ids);
}
