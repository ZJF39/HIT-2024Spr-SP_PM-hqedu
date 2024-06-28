package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    PageBean show(Integer page, Integer pageSize,String name);

    void add(Teacher teacher);

    void deletebyid(List<Integer> ids);

    void update(Teacher teacher);
}
