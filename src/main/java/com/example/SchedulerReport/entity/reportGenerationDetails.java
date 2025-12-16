/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author CCS
 */
@Data
@Entity
@Table(name = "report_generation_details", catalog = "test")
public class reportGenerationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rgd_id;
    private String rgd_request_from;
    private String rgd_request_to;
    private Date rgd_requestStartTime;
    private Date rgd_requestEndTime;

}
