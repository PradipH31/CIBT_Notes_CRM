/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller.master;

import com.cibt.crm.dto.EnquiryStatusDTO;
import com.cibt.crm.entity.master.EnquiryStatus;
import com.cibt.crm.service.EnquiryStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/admin/master/enquiry/status")
public class EnquiryStatusController extends CRUDController<EnquiryStatusDTO> {

    @Autowired
    private EnquiryStatusService service;

    public EnquiryStatusController() {
        uriPath = "master/enquirystatus/";
    }

    @GetMapping(value = "/table")
    public String table(Model model) {
        model.addAttribute("records", service.findAll());
        return uriPath + "/components/status-table";
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public EnquiryStatus getDetail(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("record", service.findById(id));
        return "master/enquirystatus/edit";
    }

    @PostMapping
    @Override
    public String save(EnquiryStatusDTO model) {
        service.save(model);
        return "redirect:/admin/master/enquiry/status";
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public boolean saveJson(EnquiryStatusDTO model) {
        return service.save(model) > 0;
    }

    @Override
    public String detail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/admin/master/enquiry/status";
    }

    @GetMapping(value = "/json")
    @ResponseBody
    public List<EnquiryStatus> json() {
        return service.findAll();
    }

}
