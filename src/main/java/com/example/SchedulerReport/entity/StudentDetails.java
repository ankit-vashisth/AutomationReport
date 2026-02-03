/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ankit Vashistha
 */
@Entity
@Table(name = "student_details", catalog = "test")
@Data
@NoArgsConstructor
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_Name")
    private String sName;

    @Column(name = "s_FatherName")
    private String sFatherName;

    @Column(name = "s_MotherName")
    private String sMotherName;

    @Column(name = "s_Standard")
    private String standard;

    @Column(name = "date")
    private Date date;

    @Column(name = "s_ObtainedMarks")
    private double obtainedMarks;

    @Column(name = "s_TotalMarks")
    private double totalMarks;

    @Column(name = "s_emailAddress")
    private String semailAddress;
}
