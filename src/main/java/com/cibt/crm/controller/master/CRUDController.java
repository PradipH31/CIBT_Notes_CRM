/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.controller.master;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author HP B&O
 */
public abstract class CRUDController<T> {

    protected String uriPath = "";

    @GetMapping
    public String index() {
        return uriPath + "/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return uriPath + "add";
    }

    public abstract String edit(int id, Model model);

    public abstract String save(T model);

    public abstract String detail(int id);

    public abstract String delete(int id);
}
