/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.UserType;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InUserTypeDao {
    List<UserType> getAllObject();

    UserType getObjectById(int id);

    void addObject(UserType obj);

    void updateObject(UserType obj);

    void deleteObject(int id);

    boolean objectExists(UserType obj);
}
