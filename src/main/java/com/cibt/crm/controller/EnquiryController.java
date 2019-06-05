/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.dto.EnquiryDTO;
import com.cibt.crm.service.EnquiryService;
import com.cibt.crm.service.EnquirySourceService;
import com.cibt.crm.service.EnquiryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "admin/enquiries")
public class EnquiryController {

    @Autowired
    private EnquirySourceService sourceService;
    @Autowired
    private EnquiryStatusService statusService;

    @Autowired
    private EnquiryService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("enquiries", service.findAll());
        return "admin/enquiries/index";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        return "admin/enquiries/add";
    }

    @PostMapping
    public String save(@ModelAttribute("EnquiryDTO") EnquiryDTO enquiry) {
        service.save(enquiry);
        return "redirect:admin/enquiries";
    }

    @PostMapping(value = "/makeVisited")
    @ResponseBody
    public String makeVisited(@RequestParam("id") int id) {
        return "" + service.makeVisited(id, true);
    }

}
