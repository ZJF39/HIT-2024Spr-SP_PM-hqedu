package com.haoqi.hqedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.CourseMapper;
import com.haoqi.hqedu.pojo.Course;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageBean show(Integer page, Integer pageSize, String name) {
        PageHelper.startPage(page,pageSize);

        List<Course> list = courseMapper.show(name);
        Page<Course> p = (Page<Course>) list;

        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());

        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        courseMapper.delete(ids);
    }

    @Override
    public void add(Course course) {
        courseMapper.add(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }
}
