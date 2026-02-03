/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.SchedulerReport.repository;

import com.example.SchedulerReport.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ankit Vashistha
 */
@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {

}
