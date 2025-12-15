/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.controller;

import com.example.SchedulerReport.Services.ReportService;
import com.example.SchedulerReport.dtoValidation.UserValidationDTO;
import com.example.SchedulerReport.entity.User;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CCS
 */
@Component
@RestController
@RequestMapping("/userController")
public class UserController {

    private ReportService reportService;

    //Constructor injection
    public UserController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/addRecord")
    public String addNewRecord(@Valid @RequestBody UserValidationDTO us) {
        reportService.newRecordRequest(us);
        return "New Record Created";
    }

    @GetMapping("/getAllRecords")
    public List<User> getAllRecords() {
        return reportService.getAllUser();
    }

    @GetMapping("/getByID/{id}")
    public User getByID(@PathVariable Long id) {
        return reportService.getUserByID(id);
    }

    @DeleteMapping("/deleteUserByID/{id}")
    public List<User> deleteByID(@PathVariable Long id) {
        return reportService.deleteUserByID(id);
    }

    @PutMapping("/updateById/{id}")
    public String updateByID(@PathVariable int id, @RequestBody User user) {
        System.out.println("From json get userId:: " + id);
        return reportService.modifyUserById(id, user);
    }
}
