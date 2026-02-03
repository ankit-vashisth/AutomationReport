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
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ankit Vashistha
 */
@Entity
@Table(name = "user_master")
@Data
@NoArgsConstructor
public class UserMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long um_id;

    @Column(name = "um_name")
    private String umName;

    @Column(name = "um_password")
    private String umPassword;

    @Column(name = "um_createdBy")
    private int umCreatedBy;

    @Column(name = "um_createdDateTime")
    private LocalDateTime umCreatedDateTime;

    @Column(name = "um_modifyBy")
    private int umModifyBy;

    @Column(name = "um_modifyDateTime")
    private LocalDateTime umModifyDateTime;
}
