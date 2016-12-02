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
import com.testdb_hsql.rolodex.Customer;
import com.testdb_hsql.rolodex.Store;
import com.testdb_hsql.rolodex.service.AddressService;

/**
 * Controller object for domain model class Address.
 * @see Address
 */
@RestController("rolodex.AddressController")
@Api(value = "AddressController", description = "Exposes APIs to work with Address resource.")
@RequestMapping("/rolodex/Address")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    @Qualifier("rolodex.AddressService")
    private AddressService addressService;

    @ApiOperation(value = "Creates a new Address instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Address createAddress(@RequestBody Address addressInstance) {
        LOGGER.debug("Create Address with information: {}", addressInstance);
        addressInstance = addressService.create(addressInstance);
        LOGGER.debug("Created Address with information: {}", addressInstance);
        return addressInstance;
    }

    @ApiOperation(value = "Returns the Address instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Address getAddress(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Address with id: {}", id);
        Address foundAddress = addressService.getById(id);
        LOGGER.debug("Address details with id: {}", foundAddress);
        return foundAddress;
    }

    @ApiOperation(value = "Updates the Address instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Address editAddress(@PathVariable("id") Integer id, @RequestBody Address addressInstance) throws EntityNotFoundException {
        LOGGER.debug("Editing Address with id: {}", addressInstance.getAddressId());
        addressInstance.setAddressId(id);
        addressInstance = addressService.update(addressInstance);
        LOGGER.debug("Address details with id: {}", addressInstance);
        return addressInstance;
    }

    @ApiOperation(value = "Deletes the Address instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAddress(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Address with id: {}", id);
        Address deletedAddress = addressService.delete(id);
        return deletedAddress != null;
    }

    /**
     * @deprecated Use {@link #findAddresses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Address instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Address> findAddresses(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Addresses list");
        return addressService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Address instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Address> findAddresses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Addresses list");
        return addressService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAddresses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return addressService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Address instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countAddresses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Addresses");
        return addressService.count(query);
    }

    @RequestMapping(value = "/{id:.+}/customers", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the customers instance associated with the given id.")
    public Page<Customer> findAssociatedCustomers(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated customers");
        return addressService.findAssociatedCustomers(id, pageable);
    }

    @RequestMapping(value = "/{id:.+}/stores", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the stores instance associated with the given id.")
    public Page<Store> findAssociatedStores(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated stores");
        return addressService.findAssociatedStores(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AddressService instance
	 */
    protected void setAddressService(AddressService service) {
        this.addressService = service;
    }
}
