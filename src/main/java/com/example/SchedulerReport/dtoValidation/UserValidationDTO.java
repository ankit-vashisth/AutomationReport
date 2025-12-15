/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.dtoValidation;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author CCS
 */
@Data
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
}
