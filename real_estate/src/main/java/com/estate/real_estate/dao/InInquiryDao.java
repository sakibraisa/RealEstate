/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Inquiry;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InInquiryDao {
    
    List<Inquiry> getAllObject();

    Inquiry getObjectById(int id);

    void addObject(Inquiry obj);

    void updateObject(Inquiry obj);

    void deleteObject(int id);

    boolean objectExists(Inquiry obj);
    
}
