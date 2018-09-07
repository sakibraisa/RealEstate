/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estate.real_estate.dao;

import com.estate.real_estate.domain.City;
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
public class CityDao implements InCityDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<City> getAllObject() {
        String hql = "FROM City as p ORDER BY p.cityId";
        return (List<City>) hibernateTemplate.find(hql);
    }

    @Override
    public City getObjectById(int id) {
        return hibernateTemplate.get(City.class, id);
    }

    @Override
    public void addObject(City obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(City obj) {

        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(City obj) {
        String hql = "FROM City as p WHERE p.cityName = ?";
        List<City> city = (List<City>) hibernateTemplate.find(hql, obj);
        return city.size() > 0 ? true : false;
    }
}
