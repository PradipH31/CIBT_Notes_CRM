/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository.impl;

import com.cibt.crm.entity.Campaign;
import com.cibt.crm.repository.CampaignRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP B&O
 */
@Repository
public class CampaignRepositoryImpl implements CampaignRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public CampaignRepositoryImpl() {
    }

    @Override
    public int insert(Campaign model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Campaign model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campaign findById(int id) {
        session = sessionFactory.openSession();
        Query query = session.getNamedQuery("campaign.findbyid");
        query.setParameter("id", id);
        if (query.getResultList().size() > 0) {
            return (Campaign) query.getSingleResult();
        }
        return null;
    }

    @Override
    public List<Campaign> getAll() {
        session = sessionFactory.openSession();
        return session.getNamedQuery("campaign.all")
                .list();
    }

    @Override
    public void save(Campaign model) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(model);
        transaction.commit();
    }

}
