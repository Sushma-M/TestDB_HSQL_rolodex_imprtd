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
import com.testdb_hsql.rolodex.Actor;
import com.testdb_hsql.rolodex.FilmActor;
import com.testdb_hsql.rolodex.service.ActorService;

/**
 * Controller object for domain model class Actor.
 * @see Actor
 */
@RestController("rolodex.ActorController")
@Api(value = "ActorController", description = "Exposes APIs to work with Actor resource.")
@RequestMapping("/rolodex/Actor")
public class ActorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    @Qualifier("rolodex.ActorService")
    private ActorService actorService;

    @ApiOperation(value = "Creates a new Actor instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Actor createActor(@RequestBody Actor actor) {
        LOGGER.debug("Create Actor with information: {}", actor);
        actor = actorService.create(actor);
        LOGGER.debug("Created Actor with information: {}", actor);
        return actor;
    }

    @ApiOperation(value = "Returns the Actor instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Actor getActor(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Actor with id: {}", id);
        Actor foundActor = actorService.getById(id);
        LOGGER.debug("Actor details with id: {}", foundActor);
        return foundActor;
    }

    @ApiOperation(value = "Updates the Actor instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Actor editActor(@PathVariable("id") Integer id, @RequestBody Actor actor) throws EntityNotFoundException {
        LOGGER.debug("Editing Actor with id: {}", actor.getActorId());
        actor.setActorId(id);
        actor = actorService.update(actor);
        LOGGER.debug("Actor details with id: {}", actor);
        return actor;
    }

    @ApiOperation(value = "Deletes the Actor instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteActor(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Actor with id: {}", id);
        Actor deletedActor = actorService.delete(id);
        return deletedActor != null;
    }

    /**
     * @deprecated Use {@link #findActors(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Actor instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Actor> findActors(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Actors list");
        return actorService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Actor instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Actor> findActors(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Actors list");
        return actorService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportActors(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return actorService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Actor instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countActors(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Actors");
        return actorService.count(query);
    }

    @RequestMapping(value = "/{id:.+}/filmActors", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the filmActors instance associated with the given id.")
    public Page<FilmActor> findAssociatedFilmActors(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated filmActors");
        return actorService.findAssociatedFilmActors(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ActorService instance
	 */
    protected void setActorService(ActorService service) {
        this.actorService = service;
    }
}
