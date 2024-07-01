package com.haoqi.hqedu.controller;


import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.pojo.StuApp;
import com.haoqi.hqedu.service.StuAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/stuapp")
public class StuAppController {

    @Autowired
    private StuAppService stuAppService;

    /**
     * 分页查询课程申请信息
     */
    @GetMapping("show")
    public Result ShowStuApp(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name){
        PageBean pageBean = stuAppService.show(page,pageSize,name);
        return Result.success(pageBean);

    }

    @DeleteMapping("/delete/{ids}")
    public Result DeleteStuApp(@PathVariable List<Integer> ids){
        stuAppService.delete(ids);
        return Result.success();
    }

    @PostMapping("/add")
    public Result InsertStuApp(@RequestBody StuApp stuApp){
        stuAppService.add(stuApp);
        return Result.success();
    }

    /**
     * 审批课程申请为通过状态
     * @param stuApp
     * @return
     */
    @PutMapping("/update")
    public Result UpdateStuApp(@RequestBody StuApp stuApp){
        stuAppService.update(stuApp);
        return Result.success();
    }

}
