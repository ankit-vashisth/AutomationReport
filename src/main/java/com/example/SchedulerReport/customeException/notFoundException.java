/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SchedulerReport.customeException;

/**
 *
 * @author Ankit Vashistha
 */
public class notFoundException extends RuntimeException {

    private String message;

    public notFoundException(String message) {
        this.message = message;
    }
}
