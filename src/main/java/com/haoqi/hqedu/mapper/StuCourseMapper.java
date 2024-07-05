package com.haoqi.hqedu.mapper;

import com.haoqi.hqedu.pojo.StuApp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuCourseMapper {


    List<StuApp> showstu(Integer id);
}
