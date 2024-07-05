package com.haoqi.hqedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.EvaMapper;
import com.haoqi.hqedu.pojo.Evaluation;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.service.EvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaServiceimpl implements EvaService {

    @Autowired
    private EvaMapper evaMapper;

    @Override
    public PageBean show(Integer page, Integer pageSize, String stuName, String courseName) {
        PageHelper.startPage(page, pageSize);
        List<Evaluation> list = evaMapper.show(stuName, courseName);
        Page<Evaluation> p = (Page<Evaluation>) list;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void insert(Evaluation evaluation) {
        evaMapper.insert(evaluation);
    }

    @Override
    public void delete(List<Integer> ids) {
        evaMapper.delete(ids);
    }
}
