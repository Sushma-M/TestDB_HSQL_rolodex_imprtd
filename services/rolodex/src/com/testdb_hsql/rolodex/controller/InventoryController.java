/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.testdb_hsql.rolodex.Inventory;
import com.testdb_hsql.rolodex.service.InventoryService;

/**
 * Controller object for domain model class Inventory.
 * @see Inventory
 */
@RestController("rolodex.InventoryController")
@Api(value = "InventoryController", description = "Exposes APIs to work with Inventory resource.")
@RequestMapping("/rolodex/Inventory")
public class InventoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    @Qualifier("rolodex.InventoryService")
    private InventoryService inventoryService;

    @ApiOperation(value = "Creates a new Inventory instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Inventory createInventory(@RequestBody Inventory inventory) {
        LOGGER.debug("Create Inventory with information: {}", inventory);
        inventory = inventoryService.create(inventory);
        LOGGER.debug("Created Inventory with information: {}", inventory);
        return inventory;
    }

    @ApiOperation(value = "Returns the Inventory instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Inventory getInventory(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Inventory with id: {}", id);
        Inventory foundInventory = inventoryService.getById(id);
        LOGGER.debug("Inventory details with id: {}", foundInventory);
        return foundInventory;
    }

    @ApiOperation(value = "Updates the Inventory instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Inventory editInventory(@PathVariable("id") Integer id, @RequestBody Inventory inventory) throws EntityNotFoundException {
        LOGGER.debug("Editing Inventory with id: {}", inventory.getInventoryId());
        inventory.setInventoryId(id);
        inventory = inventoryService.update(inventory);
        LOGGER.debug("Inventory details with id: {}", inventory);
        return inventory;
    }

    @ApiOperation(value = "Deletes the Inventory instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteInventory(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Inventory with id: {}", id);
        Inventory deletedInventory = inventoryService.delete(id);
        return deletedInventory != null;
    }

    /**
     * @deprecated Use {@link #findInventories(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Inventory instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Inventory> findInventories(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Inventories list");
        return inventoryService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Inventory instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Inventory> findInventories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Inventories list");
        return inventoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportInventories(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return inventoryService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Inventory instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countInventories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Inventories");
        return inventoryService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service InventoryService instance
	 */
    protected void setInventoryService(InventoryService service) {
        this.inventoryService = service;
    }
}