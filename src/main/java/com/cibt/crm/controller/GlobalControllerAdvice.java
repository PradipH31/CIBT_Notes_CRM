/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author HP B&O
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private JdbcTemplate template;

    @ModelAttribute
    public void getProjectName(Model model) {
        model.addAttribute("projectName", "CIBT CRM Project");
    }

    @ModelAttribute
    public void getTotalEnquiries(Model model) {
        String sql = "select count(1) from tbl_enquiries where is_read=0";
        int total = template.queryForObject(sql, Integer.class);
        model.addAttribute("totalEnquiries", total);
    }
}
