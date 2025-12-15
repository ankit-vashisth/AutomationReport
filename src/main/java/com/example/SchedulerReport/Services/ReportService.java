/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.Services;

import com.example.SchedulerReport.dtoValidation.UserValidationDTO;
import com.example.SchedulerReport.entity.User;
import com.example.SchedulerReport.repository.UserRepository;
import java.io.File;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CCS
 */
@Service
public class ReportService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private EmailService emailService;

    public void generateAndSendReport() throws Exception {

        List<User> users = getAllUser();
        System.out.println("all user total::: " + users.size());
        File excel = excelService.generateExcel(users);
        emailService.sendEmailWithAttachment(
                "ankit07v@gmail.com",
                excel
        );
        System.out.println("Report Sent Successfully!");
    }

    public void newRecordRequest(UserValidationDTO newRecord) {
        User us = new User();
        us.setSName(newRecord.getSName());
        us.setSName(newRecord.getSFatherName());
        us.setSName(newRecord.getSMotherName());
        us.setSName(newRecord.getStandard());
        us.setDate(new Date());
        us.setObtainedMarks(newRecord.getObtainedMarks());
        us.setTotalMarks(newRecord.getTotalMarks());
        int id = repo.save(us).getId();
        System.out.println("record saved in DB:::::::::::: successfully:: created id:: " + id);
    }

    public List<User> getAllUser() {
        return repo.findAll();
    }

    public User getUserByID(Long id) {
        return repo.getById(id);
    }

    public List<User> deleteUserByID(Long id) {
        repo.deleteById(id);
        return getAllUser();
    }

    public String modifyUserById(int id, User user) {
        User existing = repo.findById(Long.valueOf(id))
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
