package com.haoqi.hqedu.service;

import com.haoqi.hqedu.pojo.Company;
import com.haoqi.hqedu.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

    PageBean show(Integer page, Integer pageSize, String name);

    void insert(Company company);

    void delete(List<Integer> ids);

    void update(Company company);
}
