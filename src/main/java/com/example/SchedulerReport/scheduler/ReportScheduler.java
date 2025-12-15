/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.scheduler;

import com.example.SchedulerReport.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CCS
 */
@Component
@EnableScheduling
@RestController
@RequestMapping("/request")
public class ReportScheduler {

    @Autowired
    private ReportService reportService;

    @Scheduled(cron = "${report.cron}")
    @GetMapping("/run-report")
    public String scheduleReportJob() {
        try {
            reportService.generateAndSendReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Mail send Successfully.";
    }
}
