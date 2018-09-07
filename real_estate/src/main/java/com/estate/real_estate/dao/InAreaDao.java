/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Area;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InAreaDao {
    List<Area> getAllObject();

    Area getObjectById(int id);

    void addObject(Area obj);

    void updateObject(Area obj);

    void deleteObject(int id);

    boolean objectExists(Area obj);
}
