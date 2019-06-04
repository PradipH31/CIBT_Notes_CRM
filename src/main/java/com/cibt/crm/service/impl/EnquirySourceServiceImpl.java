/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.service.impl;

import com.cibt.crm.dto.EnquirySourceDTO;
import com.cibt.crm.entity.master.EnquirySource;
import com.cibt.crm.repository.EnquirySourceRepository;
import com.cibt.crm.service.EnquirySourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP B&O
 */
@Service
public class EnquirySourceServiceImpl implements EnquirySourceService {

    @Autowired
    private EnquirySourceRepository repository;

    @Override
    public List<EnquirySource> findAll() {
        return repository.getAll();
    }

    @Override
    public EnquirySource findById(int id) {
        return repository.findById(id);
    }

    @Override
    public int save(EnquirySourceDTO model) {
        EnquirySource source=new EnquirySource();
        source.setId(model.getId());
        source.setName(model.getName());
        source.setColor(model.getColor());
        if(source.getId()==0){
            return repository.insert(source);
        }else{
            return repository.update(source);
        }
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }

}
