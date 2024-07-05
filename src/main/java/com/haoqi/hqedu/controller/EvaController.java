package com.haoqi.hqedu.controller;


import com.haoqi.hqedu.pojo.Evaluation;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.service.EvaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/eva")
public class EvaController {

    @Autowired
    private EvaService evaService;

    /**
     * 分页查询+根据学生姓名\课程名\学生名+课程名进行模糊查询
     */
    @GetMapping("/show")
    public Result ShowEva(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String stuName,
                          String courseName){
        PageBean pageBean = evaService.show(page,pageSize,stuName,courseName);
        return Result.success(pageBean);
    }

    /**
     * 添加评价
     */
    @PostMapping("/add")
    public Result InsertEva(@RequestBody Evaluation evaluation){
        evaService.insert(evaluation);
        return Result.success();
    }

    /**
     * 删除评价
     */
    @DeleteMapping("/delete/{ids}")
    public Result DeleteEva(@PathVariable List<Integer> ids){
        evaService.delete(ids);
        return Result.success();
    }
}
