/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.controller;

import com.example.SchedulerReport.Services.ReportService;
import com.example.SchedulerReport.customeException.notFoundException;
import com.example.SchedulerReport.dtoValidation.UserValidationDTO;
import com.example.SchedulerReport.entity.StudentDetails;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ankit Vashistha
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
    public List<StudentDetails> getAllRecords() {
        List<StudentDetails> allUser = reportService.getAllUser();
        if (allUser.isEmpty()) {
            throw new notFoundException("No User Record Found");
        }
        return allUser;
    }

    @GetMapping("/getByID/{id}")
    public StudentDetails getByID(@PathVariable Long id) {
        return reportService.getUserByID(id);
    }

    @DeleteMapping("/deleteUserByID/{id}")
    public List<StudentDetails> deleteByID(@PathVariable Long id) {
        return reportService.deleteUserByID(id);
    }

    @PutMapping("/updateById/{id}")
    public String updateByID(@PathVariable int id, @RequestBody StudentDetails user) {
        System.out.println("From json get userId:: " + id);
        return reportService.modifyUserById(id, user);
    }
    
    // Adding exception handlers for NoSuchCustomerExistsException 
    // and NoSuchElementException.
    @ExceptionHandler(value = notFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFound(notFoundException ex) {
        return new ErrorResponseImpl(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    private static class ErrorResponseImpl implements ErrorResponse {
        int value ;
        String message;
        
        public ErrorResponseImpl(int value, String message) {
        this.value = value;
        this.message = message;
        }

        @Override
        public HttpStatusCode getStatusCode() {
            throw new UnsupportedOperationException(value+"_"+message);
        }

        @Override
        public ProblemDetail getBody() {
            throw new UnsupportedOperationException(message);
        }
    }
}
