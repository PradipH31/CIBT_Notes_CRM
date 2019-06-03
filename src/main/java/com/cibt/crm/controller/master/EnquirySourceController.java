/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller.master;

import com.cibt.crm.dto.EnquirySourceDTO;
import com.cibt.crm.service.EnquirySourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/admin/master/enquiry/sources")
public class EnquirySourceController extends CRUDController<EnquirySourceDTO> {

    @Autowired
    private EnquirySourceService service;

    public EnquirySourceController() {
        uriPath = "master/enquirysource/";
    }

    @GetMapping
    @Override
    public String index(Model model) {
        model.addAttribute("sources", service.findAll());
        return "master/enquirysource/index";
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id,Model model) {
        model.addAttribute("source", service.findById(id));
        return "master/enquirysource/edit";
    }

    @PostMapping
    @Override
    public String save(EnquirySourceDTO model) {
        service.save(model);
        return "redirect:/admin/master/enquiry/source";
    }

    @Override
    public String detail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
