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
import com.testdb_hsql.rolodex.Address;
import com.testdb_hsql.rolodex.City;
import com.testdb_hsql.rolodex.service.CityService;

/**
 * Controller object for domain model class City.
 * @see City
 */
@RestController("rolodex.CityController")
@Api(value = "CityController", description = "Exposes APIs to work with City resource.")
@RequestMapping("/rolodex/City")
public class CityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    @Qualifier("rolodex.CityService")
    private CityService cityService;

    @ApiOperation(value = "Creates a new City instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public City createCity(@RequestBody City cityInstance) {
        LOGGER.debug("Create City with information: {}", cityInstance);
        cityInstance = cityService.create(cityInstance);
        LOGGER.debug("Created City with information: {}", cityInstance);
        return cityInstance;
    }

    @ApiOperation(value = "Returns the City instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public City getCity(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting City with id: {}", id);
        City foundCity = cityService.getById(id);
        LOGGER.debug("City details with id: {}", foundCity);
        return foundCity;
    }

    @ApiOperation(value = "Updates the City instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public City editCity(@PathVariable("id") Integer id, @RequestBody City cityInstance) throws EntityNotFoundException {
        LOGGER.debug("Editing City with id: {}", cityInstance.getCityId());
        cityInstance.setCityId(id);
        cityInstance = cityService.update(cityInstance);
        LOGGER.debug("City details with id: {}", cityInstance);
        return cityInstance;
    }

    @ApiOperation(value = "Deletes the City instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCity(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting City with id: {}", id);
        City deletedCity = cityService.delete(id);
        return deletedCity != null;
    }

    /**
     * @deprecated Use {@link #findCities(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of City instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<City> findCities(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Cities list");
        return cityService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of City instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<City> findCities(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Cities list");
        return cityService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCities(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return cityService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of City instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countCities(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Cities");
        return cityService.count(query);
    }

    @RequestMapping(value = "/{id:.+}/addresses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the addresses instance associated with the given id.")
    public Page<Address> findAssociatedAddresses(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated addresses");
        return cityService.findAssociatedAddresses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CityService instance
	 */
    protected void setCityService(CityService service) {
        this.cityService = service;
    }
}
