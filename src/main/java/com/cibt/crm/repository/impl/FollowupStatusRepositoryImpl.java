/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository.impl;

import com.cibt.crm.entity.master.FollowupStatus;
import com.cibt.crm.repository.FollowupStatusRepository;
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
public class FollowupStatusRepositoryImpl implements FollowupStatusRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int insert(FollowupStatus model) {
        String sql = "insert into mst_followup_status(status_name,status_color) "
                + " values(?,?)";
        return template.update(sql, new Object[]{
            model.getName(), model.getColor()
        });
    }

    @Override
    public int update(FollowupStatus model) {
        String sql = "update mst_followup_status set status_name=?,"
                + "status_color=?,modified_date=CURRENT_TIMESTAMP "
                + " where id=?";
        return template.update(sql, new Object[]{
            model.getName(), model.getColor(), model.getId()
        });
    }

    @Override
    public int delete(int id) {
        String sql = "update mst_followup_status set is_deleted=1, "
                + "deleted_date=CURRENT_TIMESTAMP "
                + " where id=?";
        return template.update(sql, new Object[]{id});
    }

    @Override
    public FollowupStatus findById(int id) {
        String sql = "select * from mst_followup_status where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<FollowupStatus>() {
            @Override
            public FollowupStatus mapRow(ResultSet rs, int i) throws SQLException {
                FollowupStatus status = new FollowupStatus();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("status_name"));
                status.setColor(rs.getString("status_color"));
                status.setCreatedDate(rs.getDate("created_date"));
                status.setModifiedDate(rs.getDate("modified_date"));
                return status;
            }
        });
    }

    @Override
    public List<FollowupStatus> getAll() {
        String sql = "select * from mst_followup_status";
        return template.query(sql, new RowMapper<FollowupStatus>() {
            @Override
            public FollowupStatus mapRow(ResultSet rs, int i) throws SQLException {
                FollowupStatus status = new FollowupStatus();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("status_name"));
                status.setColor(rs.getString("status_color"));
                status.setCreatedDate(rs.getDate("created_date"));
                status.setModifiedDate(rs.getDate("modified_date"));
                return status;
            }
        });
    }
}
