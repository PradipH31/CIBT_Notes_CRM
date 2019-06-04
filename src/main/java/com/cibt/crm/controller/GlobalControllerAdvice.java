/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author HP B&O
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void getProjectName(Model model) {
        model.addAttribute("projectName", "CIBT CRM Project");
    }
}
