/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.service;

import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface GenericService<TDTO, TMODEL> {

    List<TMODEL> findAll();

    TMODEL findById(int id);

    int save(TDTO model);

    int delete(int id);
}
