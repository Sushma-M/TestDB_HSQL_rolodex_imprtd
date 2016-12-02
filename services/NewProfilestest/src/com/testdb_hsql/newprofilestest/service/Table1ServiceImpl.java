/*Generated by WaveMaker Studio*/
package com.testdb_hsql.newprofilestest.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testdb_hsql.newprofilestest.Table1;


/**
 * ServiceImpl object for domain model class Table1.
 *
 * @see Table1
 */
@Service("NewProfilestest.Table1Service")
public class Table1ServiceImpl implements Table1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table1ServiceImpl.class);


    @Autowired
    @Qualifier("NewProfilestest.Table1Dao")
    private WMGenericDao<Table1, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table1, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NewProfilestestTransactionManager")
    @Override
	public Table1 create(Table1 table1) {
        LOGGER.debug("Creating a new Table1 with information: {}", table1);
        Table1 table1Created = this.wmGenericDao.create(table1);
        return table1Created;
    }

	@Transactional(readOnly = true, value = "NewProfilestestTransactionManager")
	@Override
	public Table1 getById(Integer table1Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table1 by id: {}", table1Id);
        Table1 table1 = this.wmGenericDao.findById(table1Id);
        if (table1 == null){
            LOGGER.debug("No Table1 found with id: {}", table1Id);
            throw new EntityNotFoundException(String.valueOf(table1Id));
        }
        return table1;
    }

    @Transactional(readOnly = true, value = "NewProfilestestTransactionManager")
	@Override
	public Table1 findById(Integer table1Id) {
        LOGGER.debug("Finding Table1 by id: {}", table1Id);
        return this.wmGenericDao.findById(table1Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "NewProfilestestTransactionManager")
	@Override
	public Table1 update(Table1 table1) throws EntityNotFoundException {
        LOGGER.debug("Updating Table1 with information: {}", table1);
        this.wmGenericDao.update(table1);

        Integer table1Id = table1.getId();

        return this.wmGenericDao.findById(table1Id);
    }

    @Transactional(value = "NewProfilestestTransactionManager")
	@Override
	public Table1 delete(Integer table1Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table1 with id: {}", table1Id);
        Table1 deleted = this.wmGenericDao.findById(table1Id);
        if (deleted == null) {
            LOGGER.debug("No Table1 found with id: {}", table1Id);
            throw new EntityNotFoundException(String.valueOf(table1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "NewProfilestestTransactionManager")
	@Override
	public Page<Table1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NewProfilestestTransactionManager")
    @Override
    public Page<Table1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NewProfilestestTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NewProfilestest for table Table1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "NewProfilestestTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

