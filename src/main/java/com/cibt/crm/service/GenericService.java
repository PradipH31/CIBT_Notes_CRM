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
public interface GenericService<T> {

    List<T> findAll();

    T findById(int id);

    int save(T model);

    int delete(T model);
}
