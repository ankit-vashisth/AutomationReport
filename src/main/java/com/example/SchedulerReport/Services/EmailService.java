/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author CCS
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailsender;

    public void sendEmailWithAttachment(String to, File file) throws MessagingException {
        System.out.println("send to::: " + to);
        MimeMessage message = mailsender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject("Daily Marks Report.");
        helper.setText("Please find the attachhed Report.");
        helper.addAttachment(file.getName(), file);
        mailsender.send(message);
    }
}
