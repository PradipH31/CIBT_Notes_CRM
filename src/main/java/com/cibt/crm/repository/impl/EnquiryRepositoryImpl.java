/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository.impl;

import com.cibt.crm.entity.master.Enquiry;
import com.cibt.crm.repository.EnquiryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP B&O
 */
@Repository
public class EnquiryRepositoryImpl implements EnquiryRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int insert(Enquiry model) {
        String sql = "insert into tbl_enquiries(first_name,last_name,email,contact_no"
                + ",enquiry_source_id,enquiry_status_id,refered_by)"
                + " values(?,?,?,?,?,?,?)";
        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNo(),
            model.getSource().getId(), model.getStatus().getId(), model.getReferedBy()
        });

    }

    @Override
    public int update(Enquiry model) {
        String sql = "update tbl_enquiries set first_name=?,last_name=?,email=?,contact_no=?,"
                + "enquiry_source_id=?,enquiry_status_id=?,refered_by=?,modified_date=CURRENT_TIMESTAMP where id =?"
                + " values(?,?,?,?,?,?,?)";
        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNo(),
            model.getSource().getId(), model.getStatus().getId(), model.getReferedBy(),model.getId()
        });
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enquiry findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enquiry> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
