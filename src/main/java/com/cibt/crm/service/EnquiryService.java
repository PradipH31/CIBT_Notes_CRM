/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.service;

import com.cibt.crm.dto.EnquiryDTO;
import com.cibt.crm.entity.master.Enquiry;

/**
 *
 * @author HP B&O
 */
public interface EnquiryService extends GenericService<EnquiryDTO, Enquiry> {

    int makeVisited(int id, boolean visited);
}
