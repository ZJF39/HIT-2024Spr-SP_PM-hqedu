package com.haoqi.hqedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.TeacherMapper;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Teacher;
import com.haoqi.hqedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public PageBean show(Integer page, Integer pageSize, String name) {
        //分页参数设置
        PageHelper.startPage(page, pageSize);
        //查找
        List<Teacher> list = teacherMapper.show(name);
        Page<Teacher> p = (Page<Teacher>) list;
        //封装
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }

    @Override
    public void add(Teacher teacher) {
        teacherMapper.add(teacher);
    }

    @Override
    public void deletebyid(List<Integer> ids) {
        teacherMapper.delete(ids);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }
}
