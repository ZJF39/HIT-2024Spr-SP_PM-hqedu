package com.haoqi.hqedu.mapper;

import com.haoqi.hqedu.pojo.Stu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExpansionMapper {

    /**
     * 查询收件人
     */
    List<Stu> select(Integer ids);

}
