package com.haoqi.hqedu.util;

import com.haoqi.hqedu.pojo.Stu;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public void exportRecipientListToExcel(List<Stu> stuList) throws IOException {
        // 创建一个新的Excel工作簿

        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个工作表
        Sheet sheet = workbook.createSheet("Students");

        // 创建标题行
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("Name");
        titleRow.createCell(1).setCellValue("Tel Num");

        // 遍历学生列表，写入数据
        int rowNum = 1; // 开始于第二行（第一行为标题）
        for (Stu stu : stuList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(stu.getName());
            row.createCell(1).setCellValue(stu.getTelNum());
        }

        // 写入Excel文件
        String desktopPath = System.getProperty("user.home") + "/Desktop/RecipientList.xlsx";
        try (FileOutputStream outputStream = new FileOutputStream(desktopPath)) {
            workbook.write(outputStream);
        }

        // 关闭工作簿
        workbook.close();
    }

}
