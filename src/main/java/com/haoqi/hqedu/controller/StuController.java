package com.haoqi.hqedu.controller;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.haoqi.hqedu.pojo.Stu;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;


    /**
     * 查询全部学员信息数据
     */
    @GetMapping("/showall")
    public Result ShowAllStu(){
        log.info("查询全部学员信息");
        List<Stu> stuList = stuService.list();
        return Result.success(stuList);
    }

    /**
     * 根据id查询某位学员信息
     */
    @GetMapping("/show/{id}")
    public Result ShowStuById(@PathVariable Integer id){
        log.info("查询学员id为:{}",id);
        Stu stu = stuService.showId(id);
        return Result.success(stu);
    }

    /**
     * 按照id批量删除学员信息
     */
    @DeleteMapping("/delete/{ids}")
    public Result DeleteStuById(@PathVariable List<Integer> ids){
        log.info("删除学员id为:{}",ids);
        stuService.deletebyid(ids);
        return Result.success();
    }

    /**
     * 根据所给字段动态新增学员信息（注册）
     */
    @PostMapping("/add")
    public Result InsertStu(@RequestBody Stu stu){
        log.info("添加学员id为:{}",stu.getId());
        stuService.add(stu);
        return Result.success();
    }

    /**
     * 根据所传内容动态修改学员信息
     */
    @PutMapping("/update")
    public Result UpdateStu(@RequestBody Stu stu){
        log.info("更新学员id为:{}",stu.getId());
        stuService.update(stu);
        return Result.success();
    }

    /**
     * 根据所传内容按条件查询学员信息并分页展示
     */
    @GetMapping("/showpages")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name){

        log.info("分页查询学员信息:{},{},{}",page,pageSize,name);
        PageBean pageBean = stuService.page(page,pageSize,name);
        return Result.success(pageBean);
    }
}
