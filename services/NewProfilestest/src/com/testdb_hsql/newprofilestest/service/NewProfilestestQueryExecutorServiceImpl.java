/*Generated by WaveMaker Studio*/

package com.testdb_hsql.newprofilestest.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

@Service
public class NewProfilestestQueryExecutorServiceImpl implements NewProfilestestQueryExecutorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewProfilestestQueryExecutorServiceImpl.class);

	@Autowired
	@Qualifier("NewProfilestestWMQueryExecutor")
	private WMQueryExecutor queryExecutor;


	@Transactional(value = "NewProfilestestTransactionManager")
	@Override
	public Page<Object> executeWMCustomQuerySelect(CustomQuery query, Pageable pageable) {
	    return queryExecutor.executeCustomQuery(query, pageable);
	}

	@Transactional(value = "NewProfilestestTransactionManager")
    @Override
    public int executeWMCustomQueryUpdate(CustomQuery query) {
        return queryExecutor.executeCustomQueryForUpdate(query);
    }
}

