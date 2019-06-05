/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository.impl;

import com.cibt.crm.entity.master.Enquiry;
import com.cibt.crm.entity.master.EnquirySource;
import com.cibt.crm.entity.master.EnquiryStatus;
import com.cibt.crm.repository.EnquiryRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        String sql = "update tbl_enquiries set first_name=?,last_name=?,"
                + "email=?,contact_no=?,enquiry_source_id=?,"
                + "enquiry_status_id=?,refered_by=?,is_visited=?,modified_date=CURRENT_TIMESTAMP "
                + " where id=?";
        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(),
            model.getContactNo(), model.getSource().getId(), model.getStatus().getId(),
            model.getReferedBy(), model.isVisited(), model.getId()
        });
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enquiry findById(int id) {
        String sql = "select * from tbl_enquiries where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<Enquiry>() {
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                Enquiry enquiry = new Enquiry();
                enquiry.setId(rs.getInt("id"));
                enquiry.setFirstName(rs.getString("first_name"));
                enquiry.setLastName(rs.getString("last_name"));
                enquiry.setEmail(rs.getString("email"));
                enquiry.setContactNo(rs.getString("contact_no"));
                enquiry.setReferedBy(rs.getString("refered_by"));
                enquiry.setSource(new EnquirySource(rs.getInt("enquiry_source_id")));
                enquiry.setStatus(new EnquiryStatus(rs.getInt("enquiry_status_id")));
                enquiry.setCreatedDate(rs.getDate("created_date"));
                enquiry.setVisited(rs.getBoolean("is_visited"));
                return enquiry;
            }
        });
    }

    @Override
    public List<Enquiry> getAll() {
        String sql = "select enq.*,sts.status_name, sts.status_color,"
                + "srs.source_name,srs.source_color from tbl_enquiries enq"
                + " left join vw_enquiry_status sts on sts.id=enq.enquiry_status_id"
                + " left join vw_enquiry_source srs on srs.id=enq.enquiry_source_id";
        return template.query(sql, new RowMapper<Enquiry>() {
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                Enquiry enquiry = new Enquiry();
                enquiry.setId(rs.getInt("id"));
                enquiry.setFirstName(rs.getString("first_name"));
                enquiry.setLastName(rs.getString("last_name"));
                enquiry.setEmail(rs.getString("email"));
                enquiry.setContactNo(rs.getString("contact_no"));
                enquiry.setReferedBy(rs.getString("refered_by"));
                enquiry.setSource(new EnquirySource(rs.getInt("enquiry_source_id"),
                        rs.getString("source_name"), rs.getString("source_color")));
                enquiry.setStatus(new EnquiryStatus(rs.getInt("enquiry_status_id"),
                        rs.getString("status_name"), rs.getString("status_color")));
                enquiry.setCreatedDate(rs.getDate("created_date"));
                enquiry.setVisited(rs.getBoolean("is_visited"));
                return enquiry;
            }
        });
    }

}
