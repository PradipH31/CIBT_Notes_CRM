/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.service.impl;

import com.cibt.crm.dto.FollowupStatusDTO;
import com.cibt.crm.entity.master.FollowupStatus;
import com.cibt.crm.repository.FollowupStatusRepository;
import com.cibt.crm.service.FollowupStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP B&O
 */
@Service
public class FollowupStatusServiceImpl implements FollowupStatusService{

    @Autowired
    private FollowupStatusRepository repository;
    
    @Override
    public List<FollowupStatus> findAll() {
        return repository.getAll();
    }

    @Override
    public FollowupStatus findById(int id) {
        return repository.findById(id);
    }

    @Override
    public int save(FollowupStatusDTO model) {
        FollowupStatus status = new FollowupStatus();
        status.setId(model.getId());
        status.setName(model.getName());
        status.setColor(model.getColor());
        if(status.getId() == 0){
            return repository.insert(status);
        }
        return repository.update(status);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
    
}
