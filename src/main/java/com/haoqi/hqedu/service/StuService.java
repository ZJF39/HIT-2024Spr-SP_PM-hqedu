package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.pojo.Stu;

import java.util.List;

public interface StuService {
    List<Stu> list();

    void deletebyid(List<Integer> ids);

    void add(Stu stu);

    Stu showId(Integer id);

    void update(Stu stu);

    PageBean page(Integer page, Integer pageSize,String name);

    Stu login(Stu stu);
}
