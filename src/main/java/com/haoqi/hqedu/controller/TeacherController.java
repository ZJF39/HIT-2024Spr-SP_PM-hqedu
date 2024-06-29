package com.haoqi.hqedu.controller;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.pojo.Stu;
import com.haoqi.hqedu.pojo.Teacher;
import com.haoqi.hqedu.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tea")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 展示全部教师信息,并分页显示，并可按姓名查询
     */
    @GetMapping("/show")
    public Result ShowTea(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String name) {
        log.info("分页展示教师信息:{}{}{}", page, pageSize, name);
        PageBean pageBean = teacherService.show(page, pageSize, name);
        return Result.success(pageBean);
    }

    /**
     * 根据所给字段动态新增讲师信息
     */
    @PostMapping("/add")
    public Result InsertTea(@RequestBody Teacher teacher) {
        teacherService.add(teacher);
        return Result.success();
    }

    /**
     * 按照id批量删除讲师信息
     */
    @DeleteMapping("/delete/{ids}")
    public Result DeleteTeaById(@PathVariable List<Integer> ids) {
        log.info("删除老师id为:{}", ids);
        teacherService.deletebyid(ids);
        return Result.success();
    }

    @PutMapping("/update")
    public Result UpdateTea(@RequestBody Teacher teacher) {
        teacherService.update(teacher);
        return Result.success();
    }

}
