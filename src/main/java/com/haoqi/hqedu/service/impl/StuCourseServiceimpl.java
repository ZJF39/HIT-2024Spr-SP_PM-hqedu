package com.haoqi.hqedu.service.impl;

import com.haoqi.hqedu.mapper.StuCourseMapper;
import com.haoqi.hqedu.pojo.StuApp;
import com.haoqi.hqedu.service.StuCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuCourseServiceimpl implements StuCourseService {

    @Autowired
    private StuCourseMapper stuCourseMapper;


    @Override
    public List showstu(Integer id) {
        List<StuApp> list = stuCourseMapper.showstu(id);
        return list;
    }
}
