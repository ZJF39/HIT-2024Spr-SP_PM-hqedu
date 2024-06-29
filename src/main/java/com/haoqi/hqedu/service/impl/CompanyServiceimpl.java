package com.haoqi.hqedu.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoqi.hqedu.mapper.CompanyMapper;
import com.haoqi.hqedu.pojo.Company;
import com.haoqi.hqedu.pojo.PageBean;
import com.haoqi.hqedu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceimpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public PageBean show(Integer page, Integer pageSize, String name) {
        PageHelper.startPage(page,pageSize);
        List<Company> list = companyMapper.show(name);
        Page p = (Page<Company>) list;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return  pageBean;

    }

    @Override
    public void insert(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public void delete(List<Integer> ids) {
        companyMapper.delete(ids);
    }

    @Override
    public void update(Company company) {
        companyMapper.update(company);
    }
}
