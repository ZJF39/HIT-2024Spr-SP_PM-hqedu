package com.haoqi.hqedu.controller;


import com.haoqi.hqedu.pojo.*;
import com.haoqi.hqedu.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 查询课程信息
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("show")
    public Result ShowCourse(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name){
        PageBean pageBean = courseService.show(page,pageSize,name);
        return Result.success(pageBean);
    }


    @DeleteMapping("/delete/{ids}")
    public Result DeleteCourse(@PathVariable List<Integer> ids){
        courseService.delete(ids);
        return Result.success();
    }

    /**
     * 新增培训课程信息
     */
    @PostMapping("/add")
    public Result InsertCourse(@RequestBody Course course) {
        courseService.add(course);
        return Result.success();
    }

    @PutMapping("/update")
    public Result UpdateCourse(@RequestBody Course course) {
        courseService.update(course);
        return Result.success();
    }
}
