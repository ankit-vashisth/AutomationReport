/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.Services;

import com.example.SchedulerReport.entity.StudentDetails;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ankit Vashistha
 */
@Service
public class ExcelService {

    public File generateExcel(List<StudentDetails> users) throws FileNotFoundException, IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("User Report");
        int num = 0;
        Row header = sheet.createRow(num++);
        header.createCell(0).setCellValue("Id");
        header.createCell(1).setCellValue("S_Name");
        header.createCell(2).setCellValue("S_FatherName");
        header.createCell(3).setCellValue("S_MotherName");
        header.createCell(4).setCellValue("S_Standard");
        header.createCell(5).setCellValue("Date");
        header.createCell(6).setCellValue("Obtained_Marks");
        header.createCell(7).setCellValue("Total_Marks");

        for (StudentDetails u : users) {
            Row row = sheet.createRow(num++);
            row.createCell(0).setCellValue(u.getId());
            row.createCell(1).setCellValue(u.getSName());
            row.createCell(2).setCellValue(u.getSFatherName());
            row.createCell(3).setCellValue(u.getSMotherName());
            row.createCell(4).setCellValue(u.getStandard());
            row.createCell(5).setCellValue(u.getDate().toString());
            row.createCell(6).setCellValue(u.getObtainedMarks());
            row.createCell(7).setCellValue(u.getTotalMarks());
        }

        File file = new File("UserReport_" + System.currentTimeMillis() + ".xlsx");
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        workbook.close();
        return file;
    }
}
