/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.repository;

import com.cibt.crm.entity.Campaign;

/**
 *
 * @author HP B&O
 */
public interface CampaignRepository extends GenericRepository<Campaign> {

    void save(Campaign model);
}
