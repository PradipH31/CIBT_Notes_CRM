/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller.master;

import com.cibt.crm.dto.FollowupStatusDTO;
import com.cibt.crm.entity.master.FollowupStatus;
import com.cibt.crm.service.FollowupStatusService;
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
@RequestMapping(value="/admin/master/followup/status")
public class FollowupStatusController extends CRUDController<FollowupStatusDTO> {

    public FollowupStatusController(){
        uriPath = "master/followupstatus/";
    }
    
    @GetMapping(value = "/table")
    public String table(Model model) {
        model.addAttribute("records", service.findAll());
        return uriPath+"/components/status-table";
    }
    
    @GetMapping(value = "/json")
    @ResponseBody
    public List<FollowupStatus> json(){
        return service.findAll();
    }
    
    @GetMapping(value = "/{id}")
    @ResponseBody
    public FollowupStatus getDetail(@PathVariable("id")int id) {
        return service.findById(id);
    }
    
    @Autowired
    private FollowupStatusService service;
    
    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id")int id, Model model) {
        model.addAttribute("record", service.findById(id));
        return "master/followupstatus/edit";
    }

    @PostMapping
    @Override
    public String save(FollowupStatusDTO model) {
        service.save(model);
        return "redirect:/admin/master/followup/status";
    }

    @Override
    public String detail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping(value="/delete/{id}")
    @Override
    public String delete(@PathVariable("id")int id) {
        service.delete(id);
        return "redirect:/admin/master/followup/status";
    }
    
    @PostMapping(value = "save")
    @ResponseBody
    public boolean saveJson(FollowupStatusDTO model) {
        int result = service.save(model);
        return result > 0;
    }
    
}
