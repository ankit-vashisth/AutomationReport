/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.dtoValidation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ankit Vashistha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserValidationDTO {

    @NotBlank(message = "Student name can't be empty")
    private String sName;

    @NotBlank(message = "Father name can't be empty")
    private String sFatherName;

    @NotBlank(message = "Mother name can't be empty")
    private String sMotherName;

    @NotBlank(message = "Standard can't be empty")
    private String standard;

    @NotBlank(message = "Obtained marks is mandatory")
    private double obtainedMarks;

    @NotBlank(message = "Total marks is mandatory.")
    private double totalMarks;
    
    @Email(message = "Please enter a valid email address.")
    private String emailAddress;
}
