package com.haoqi.hqedu.controller;


import com.haoqi.hqedu.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import com.haoqi.hqedu.service.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.haoqi.hqedu.pojo.Stu;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/expansion")
public class ExpansionController {
    @Autowired
    private ExpansionService expansionService;

    /**
     * 依据课程id生成收件人名单
     */
    @GetMapping("/generateRecipientList/{ids}")
    public Result generateRecipientList(@PathVariable Integer ids) {
        log.info("生成收件人名单");
        expansionService.generateRecipientList(ids);
        return Result.success();
    }
}
