/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository.impl;

import com.cibt.crm.entity.master.EnquirySource;
import com.cibt.crm.repository.EnquirySourceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP B&O
 */
@Repository
public class EnquirySourceRepositoryImpl implements EnquirySourceRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int insert(EnquirySource model) {
        String sql = "insert into mst_enquiry_sources(source_name,source_color)"
                + " values(?,?)";
        return template.update(sql, new Object[]{
            model.getName(), model.getColor()
        });
    }

    @Override
    public int update(EnquirySource model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(EnquirySource model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EnquirySource findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EnquirySource> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
