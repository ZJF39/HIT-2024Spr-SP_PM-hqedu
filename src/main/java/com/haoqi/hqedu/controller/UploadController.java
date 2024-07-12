package com.haoqi.hqedu.controller;

import com.aliyun.oss.AliOSSUtils;
import com.haoqi.hqedu.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    // 自定义starter，封装了自动配置oss工具类
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
