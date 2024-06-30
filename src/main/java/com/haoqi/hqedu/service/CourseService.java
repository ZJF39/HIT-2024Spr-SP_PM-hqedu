package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.Course;
import com.haoqi.hqedu.pojo.PageBean;

import java.util.List;

public interface CourseService {
    PageBean show(Integer page, Integer pageSize, String name);

    void delete(List<Integer> ids);

    void add(Course course);

    void update(Course course);
}
