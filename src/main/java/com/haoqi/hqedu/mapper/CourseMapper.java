package com.haoqi.hqedu.mapper;

import com.haoqi.hqedu.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> show(String name);

    void delete(List<Integer> ids);

    void add(Course course);

    void update(Course course);
}
