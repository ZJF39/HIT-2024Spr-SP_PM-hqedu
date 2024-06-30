package com.haoqi.hqedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.TrainAppMapper;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.TrainApp;
import com.haoqi.hqedu.service.TeacherService;
import com.haoqi.hqedu.service.TrainAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainAppServiceimpl implements TrainAppService {

    @Autowired
    private TrainAppMapper trainAppMapper;

    @Override
    public PageBean show(Integer page, Integer pageSize, String name) {
        PageHelper.startPage(page,pageSize);
        List<TrainApp> list = trainAppMapper.show(name);
        Page<TrainApp> p = (Page<TrainApp>) list;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        trainAppMapper.delete(ids);
    }

    @Override
    public void add(TrainApp trainApp) {
        trainAppMapper.add(trainApp);
    }
}
