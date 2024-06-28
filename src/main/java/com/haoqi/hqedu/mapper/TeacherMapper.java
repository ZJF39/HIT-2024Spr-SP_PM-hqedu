package com.haoqi.hqedu.mapper;


import com.haoqi.hqedu.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    List<Teacher> show(String name);

    void add(Teacher teacher);

    void delete(List<Integer> ids);

    void update(Teacher teacher);
}