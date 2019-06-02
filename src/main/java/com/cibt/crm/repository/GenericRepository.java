/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository;

import java.util.List;

/**
 *
 * @author HP B&O
 */
public interface GenericRepository<T> {

    int insert(T model);

    int update(T model);

    int delete(int id);

    T findById(int id);

    List<T> getAll();
}
