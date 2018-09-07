/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Feedback;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author C6
 */
@Transactional
@Repository
public class FeedbackDao implements InFeedbackDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Feedback> getAllObject() {
        String hql = "FROM Feedback p LEFT JOIN FETCH  p.user LEFT JOIN FETCH  p.inquiry ORDER BY p.feedId";
        return (List<Feedback>) hibernateTemplate.find(hql);
    }

    @Override
    public Feedback getObjectById(int id) {
        return hibernateTemplate.get(Feedback.class, id);
    }

    @Override
    public void addObject(Feedback obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Feedback obj) {

        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Feedback obj) {
        String hql = "FROM Feedback as p WHERE p.feedTitle = ?";
        List<Feedback> feedback = (List<Feedback>) hibernateTemplate.find(hql, obj);
        return feedback.size() > 0 ? true : false;
    }

}
