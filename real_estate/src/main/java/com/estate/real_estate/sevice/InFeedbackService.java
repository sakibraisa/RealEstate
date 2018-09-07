/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.domain.Feedback;
import java.util.List;

/**
 *
 * @author C6
 */
public interface InFeedbackService {
    List<Feedback> getAllObject();

    Feedback getObjectById(int id);

    boolean addObject(Feedback obj);

    void updateObject(Feedback obj);

    void deleteObject(int id);
}
