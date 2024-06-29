package com.haoqi.hqedu.controller;


import com.haoqi.hqedu.pojo.Company;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Result;
import com.haoqi.hqedu.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/com")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 分页展示各企业信息，并可根据企业名称模糊查询
     */
    @GetMapping("/show")
    public Result ShowCompany(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              String name){
        PageBean pageBean = companyService.show(page,pageSize,name);
        return Result.success(pageBean);
    }

    /**
     * 新增企业信息
     */
    @PostMapping("/add")
    public Result InsertCompany(@RequestBody Company company){
        companyService.insert(company);
        return Result.success();
    }

    /**
     * 删除企业信息
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/{ids}")
    public Result DeleteCompany(@PathVariable List<Integer> ids){
        companyService.delete(ids);
        return Result.success();
    }

    /**
     * 更新企业信息
     */
    @PutMapping("/update")
    public Result UpdateCompany(@RequestBody Company company){
        companyService.update(company);
        return Result.success();

    }
}
