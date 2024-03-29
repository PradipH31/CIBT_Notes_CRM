/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller;

import com.cibt.crm.entity.Campaign;
import com.cibt.crm.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HP B&O
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private CampaignRepository repo;

    @GetMapping
    @ResponseBody
    public String index() {
        String content = "";
        for (Campaign c : repo.getAll()) {
            content += c.getName();
        }
        Campaign campaign = repo.findById(9);
        if (campaign != null) {
            content += "<br>";
            content += campaign;
        } else {
            content += "No data";
        }
        return content;
//        return "index";
    }
}
