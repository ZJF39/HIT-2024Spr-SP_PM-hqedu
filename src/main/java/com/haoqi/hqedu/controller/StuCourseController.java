package com.haoqi.hqedu.controller;


import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.pojo.StuApp;
import com.haoqi.hqedu.service.StuCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class StuCourseController {

    @Autowired
    private StuCourseService stuCourseService;


    @GetMapping("/showstu/{id}")
    public Result ShowStuByCourse(@PathVariable Integer id) {
        List<StuApp> list =stuCourseService.showstu(id);
        return Result.success(list);
    }


}
