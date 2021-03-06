/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex.service;

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

import com.testdb_hsql.rolodex.Inventory;


/**
 * ServiceImpl object for domain model class Inventory.
 *
 * @see Inventory
 */
@Service("rolodex.InventoryService")
public class InventoryServiceImpl implements InventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);


    @Autowired
    @Qualifier("rolodex.InventoryDao")
    private WMGenericDao<Inventory, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Inventory, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "rolodexTransactionManager")
    @Override
	public Inventory create(Inventory inventory) {
        LOGGER.debug("Creating a new Inventory with information: {}", inventory);
        Inventory inventoryCreated = this.wmGenericDao.create(inventory);
        return inventoryCreated;
    }

	@Transactional(readOnly = true, value = "rolodexTransactionManager")
	@Override
	public Inventory getById(Integer inventoryIdInstance) throws EntityNotFoundException {
        LOGGER.debug("Finding Inventory by id: {}", inventoryIdInstance);
        Inventory inventory = this.wmGenericDao.findById(inventoryIdInstance);
        if (inventory == null){
            LOGGER.debug("No Inventory found with id: {}", inventoryIdInstance);
            throw new EntityNotFoundException(String.valueOf(inventoryIdInstance));
        }
        return inventory;
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
	@Override
	public Inventory findById(Integer inventoryIdInstance) {
        LOGGER.debug("Finding Inventory by id: {}", inventoryIdInstance);
        return this.wmGenericDao.findById(inventoryIdInstance);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "rolodexTransactionManager")
	@Override
	public Inventory update(Inventory inventory) throws EntityNotFoundException {
        LOGGER.debug("Updating Inventory with information: {}", inventory);
        this.wmGenericDao.update(inventory);

        Integer inventoryIdInstance = inventory.getInventoryId();

        return this.wmGenericDao.findById(inventoryIdInstance);
    }

    @Transactional(value = "rolodexTransactionManager")
	@Override
	public Inventory delete(Integer inventoryIdInstance) throws EntityNotFoundException {
        LOGGER.debug("Deleting Inventory with id: {}", inventoryIdInstance);
        Inventory deleted = this.wmGenericDao.findById(inventoryIdInstance);
        if (deleted == null) {
            LOGGER.debug("No Inventory found with id: {}", inventoryIdInstance);
            throw new EntityNotFoundException(String.valueOf(inventoryIdInstance));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "rolodexTransactionManager")
	@Override
	public Page<Inventory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Inventories");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Page<Inventory> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Inventories");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "rolodexTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service rolodex for table Inventory to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "rolodexTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

