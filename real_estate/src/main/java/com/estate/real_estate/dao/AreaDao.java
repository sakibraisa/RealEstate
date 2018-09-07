/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.Area;
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
public class AreaDao implements InAreaDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Area> getAllObject() {
      String hql = "FROM Area p LEFT JOIN FETCH  p.city ORDER BY p.areaId";
        return (List<Area>) hibernateTemplate.find(hql);
    }

    @Override
    public Area getObjectById(int id) {
        return hibernateTemplate.get(Area.class, id);
    }

    @Override
    public void addObject(Area obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Area obj) {

        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Area obj) {
        String hql = "FROM Area as p WHER p.areaName=?";
        List<Area> area = (List<Area>) hibernateTemplate.find(hql, obj);
        return area.size() > 0 ? true : false;
    }
}
