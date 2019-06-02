/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.crm.dto;

/**
 *
 * @author HP B&O
 */
public class EnquiryDTO {

    private int id;
    private String firstName, lastName, email, contactNo, referedBy;
    private int enquiryStatus, enquirySource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getReferedBy() {
        return referedBy;
    }

    public void setReferedBy(String referedBy) {
        this.referedBy = referedBy;
    }

    public int getEnquiryStatus() {
        return enquiryStatus;
    }

    public void setEnquiryStatus(int enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }

    public int getEnquirySource() {
        return enquirySource;
    }

    public void setEnquirySource(int enquirySource) {
        this.enquirySource = enquirySource;
    }
    
    
}
