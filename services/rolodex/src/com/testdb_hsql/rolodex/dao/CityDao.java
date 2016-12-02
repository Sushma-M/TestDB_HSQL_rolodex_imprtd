/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.testdb_hsql.rolodex.City;

/**
 * Specifies methods used to obtain and modify City related information
 * which is stored in the database.
 */
@Repository("rolodex.CityDao")
public class CityDao extends WMGenericDaoImpl<City, Integer> {

    @Autowired
    @Qualifier("rolodexTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}
