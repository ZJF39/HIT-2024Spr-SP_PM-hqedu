package com.haoqi.hqedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.StuMapper;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Stu;
import com.haoqi.hqedu.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceimpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Stu> list() {
        return stuMapper.list();
    }

    @Override
    public void deletebyid(List<Integer> ids) {
        stuMapper.deletebyid(ids);
    }

    @Override
    public void add(Stu stu) {
        stuMapper.add(stu);
    }

    @Override
    public Stu showId(Integer id) {
        return stuMapper.showId(id);
    }

    @Override
    public void update(Stu stu) {
        stuMapper.update(stu);
    }

    /*@Override
    public PageBean page(Integer page, Integer pageSize) {
        Integer count = stuMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Stu> stuList = stuMapper.page(start, pageSize);
        PageBean pageBean = new PageBean(count, stuList);
        return pageBean;
    }*/

    @Override
    public PageBean page(Integer page, Integer pageSize, String name) {
        //1.设置分页参数
        PageHelper.startPage(page,pageSize);
        //2.查询
        List<Stu> stuList = stuMapper.page(name);
        Page<Stu> P = (Page<Stu>) stuList;
        //3.封装
        PageBean pageBean = new PageBean(P.getTotal(), P.getResult());
        return pageBean;
    }
}
