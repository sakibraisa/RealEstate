/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.domain.Property;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InPropertyService {
    List<Property> getAllObject();

    Property getObjectById(int id);

    void addObject(Property obj);

    void updateObject(Property obj);

    void deleteObject(int id);
}
