package com.haoqi.hqedu.service.impl;

import com.haoqi.hqedu.pojo.Stu;
import com.haoqi.hqedu.mapper.ExpansionMapper;
import com.haoqi.hqedu.service.ExpansionService;
import com.haoqi.hqedu.util.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class ExpansionServiceimpl implements ExpansionService {
    @Autowired
    private ExpansionMapper expansionMapper;

    @Override
    public void generateRecipientList(Integer ids) {
        List<Stu> stuList = expansionMapper.select(ids);
        ExcelExporter excelExporter = new ExcelExporter();
        try{
            excelExporter.exportRecipientListToExcel(stuList);
        }
        catch (IOException ignored){
        }
    }
}
