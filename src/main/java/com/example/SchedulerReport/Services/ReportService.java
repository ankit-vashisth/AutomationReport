/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.Services;

import com.example.SchedulerReport.dtoValidation.UserValidationDTO;
import com.example.SchedulerReport.entity.StudentDetails;
import java.io.File;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SchedulerReport.repository.StudentDetailsRepository;

/**
 *
 * @author Ankit Vashistha
 */
@Service
public class ReportService {

    @Autowired
    private StudentDetailsRepository repo;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private EmailService emailService;
    
    public void generateAndSendReport() throws Exception {

        List<StudentDetails> users = getAllUser();
        System.out.println("all user total::: " + users.size());
        File excel = excelService.generateExcel(users);
        emailService.sendEmailWithAttachment(
                "singhsonu6798@gmail.com",
                excel
        );
        System.out.println("Report Sent Successfully!");
    }

    public void newRecordRequest(UserValidationDTO newRecord) {
        StudentDetails usr = new StudentDetails();
        usr.setSName(newRecord.getSName());
        usr.setSFatherName(newRecord.getSFatherName());
        usr.setSMotherName(newRecord.getSMotherName());
        usr.setStandard(newRecord.getStandard());
        usr.setSemailAddress(newRecord.getEmailAddress());
        usr.setDate(new Date());
        usr.setObtainedMarks(newRecord.getObtainedMarks());
        usr.setTotalMarks(newRecord.getTotalMarks());
        Long id = repo.save(usr).getId();
        System.out.println("record saved in DB:::::::::::: successfully:: created id:: " + id);
    }

    public List<StudentDetails> getAllUser() {
        return repo.findAll();
    }

    public StudentDetails getUserByID(Long id) {
        return repo.getById(id);
    }

    public List<StudentDetails> deleteUserByID(Long id) {
        repo.deleteById(id);
        return getAllUser();
    }

    public String modifyUserById(int id, StudentDetails user) {
        StudentDetails existing = repo.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setSName(user.getSName());
        existing.setSFatherName(user.getSFatherName());
        existing.setSMotherName(user.getSMotherName());
        existing.setStandard(user.getStandard());
        existing.setDate(user.getDate());
        existing.setObtainedMarks(user.getObtainedMarks());
        existing.setTotalMarks(user.getTotalMarks());

        repo.save(existing);

        return "User updated successfully with ID: " + id;
    }
}
