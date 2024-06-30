package com.haoqi.hqedu.controller;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.pojo.Teacher;
import com.haoqi.hqedu.pojo.TrainApp;
import com.haoqi.hqedu.service.TrainAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/train")
public class TrainAppController {

    @Autowired
    private TrainAppService trainAppService;

    /**
     * 查询培训项目及培训项目来源公司
     * @return
     */
    @GetMapping("/show")
    public Result ShowTrain(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            String name){
        PageBean pageBean = trainAppService.show(page,pageSize,name);
        return Result.success(pageBean);
    }

    @DeleteMapping("/delete/{ids}")
    public Result DeleteTrain(@PathVariable List<Integer> ids){
        trainAppService.delete(ids);
        return Result.success();
    }

    /**
     * 新增培训申请信息
     */
    @PostMapping("/add")
    public Result InsertTea(@RequestBody TrainApp trainApp) {
        trainAppService.add(trainApp);
        return Result.success();
    }
}
