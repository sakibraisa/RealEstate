/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.ProType;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InProTypeDao {
    List<ProType> getAllObject();

    ProType getObjectById(int id);

    void addObject(ProType obj);

    void updateObject(ProType obj);

    void deleteObject(int id);

    boolean objectExists(ProType obj);
}
