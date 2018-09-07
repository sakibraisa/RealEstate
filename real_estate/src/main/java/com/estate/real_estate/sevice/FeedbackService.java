/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.sevice;

import com.estate.real_estate.dao.InFeedbackDao;
import com.estate.real_estate.domain.Feedback;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author C6
 */
@Service
public class FeedbackService implements InFeedbackService {

    @Autowired
    private InFeedbackDao InFeedbackDao;
    

    @Override
    public List<Feedback> getAllObject() {
        return InFeedbackDao.getAllObject();
    }

    @Override
    public Feedback getObjectById(int id) {
        Feedback obj= InFeedbackDao.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(Feedback obj) {
        InFeedbackDao.addObject(obj);
        return false;
    }

    @Override
    public void updateObject(Feedback obj) {
        InFeedbackDao.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        InFeedbackDao.deleteObject(id);
    }

}
