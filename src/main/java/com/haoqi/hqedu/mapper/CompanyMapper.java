package com.haoqi.hqedu.mapper;


import com.haoqi.hqedu.pojo.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    List<Company> show(String name);

    void insert(Company company);

    void delete(List<Integer> ids);

    void update(Company company);
}
