package com.haoqi.hqedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.StuAppMapper;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.StuApp;
import com.haoqi.hqedu.service.StuAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuAppServiceimpl implements StuAppService {

    @Autowired
    private StuAppMapper stuAppMapper;

    @Override
    public PageBean show(Integer page, Integer pageSize, String stuName) {
        PageHelper.startPage(page,pageSize);
        List<StuApp> list = stuAppMapper.show(stuName);
        Page<StuApp> stuAppPage = (Page<StuApp>) list;
        return new PageBean(stuAppPage.getTotal(),stuAppPage.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        stuAppMapper.delete(ids);
    }

    @Override
    public void add(StuApp stuApp) {
        stuAppMapper.add(stuApp);
    }

    @Override
    public void update(StuApp stuApp) {
        stuAppMapper.update(stuApp);
    }
}
