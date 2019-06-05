/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.service.impl;

import com.cibt.crm.dto.EnquiryDTO;
import com.cibt.crm.entity.master.Enquiry;
import com.cibt.crm.repository.EnquiryRepository;
import com.cibt.crm.service.EnquiryService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP B&O
 */
@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Enquiry> findAll() {
        return repository.getAll();
    }

    @Override
    public Enquiry findById(int id) {
        return repository.findById(id);
    }

    @Override
    public int save(EnquiryDTO model) {
        Enquiry enquiry = mapper.map(model, Enquiry.class);
        if (enquiry.getId() == 0) {
            return repository.insert(enquiry);
        }
        return repository.update(enquiry);
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int makeVisited(int id, boolean visited) {
        int result = 0;
        Enquiry enquiry = repository.findById(id);
        if (enquiry != null) {
            enquiry.setVisited(visited);
            result = repository.update(enquiry);
        }
        return result;
    }
}
