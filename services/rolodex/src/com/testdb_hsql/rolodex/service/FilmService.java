/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testdb_hsql.rolodex.Film;
import com.testdb_hsql.rolodex.FilmActor;
import com.testdb_hsql.rolodex.Inventory;

/**
 * Service object for domain model class {@link Film}.
 */
public interface FilmService {

    /**
     * Creates a new Film. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Film if any.
     *
     * @param film Details of the Film to be created; value cannot be null.
     * @return The newly created Film.
     */
	Film create(Film film);


	/**
	 * Returns Film by given id if exists.
	 *
	 * @param filmIdInstance The id of the Film to get; value cannot be null.
	 * @return Film associated with the given filmIdInstance.
     * @throws EntityNotFoundException If no Film is found.
	 */
	Film getById(Integer filmIdInstance) throws EntityNotFoundException;

    /**
	 * Find and return the Film by given id if exists, returns null otherwise.
	 *
	 * @param filmIdInstance The id of the Film to get; value cannot be null.
	 * @return Film associated with the given filmIdInstance.
	 */
	Film findById(Integer filmIdInstance);


	/**
	 * Updates the details of an existing Film. It replaces all fields of the existing Film with the given film.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Film if any.
     *
	 * @param film The details of the Film to be updated; value cannot be null.
	 * @return The updated Film.
	 * @throws EntityNotFoundException if no Film is found with given input.
	 */
	Film update(Film film) throws EntityNotFoundException;

    /**
	 * Deletes an existing Film with the given id.
	 *
	 * @param filmIdInstance The id of the Film to be deleted; value cannot be null.
	 * @return The deleted Film.
	 * @throws EntityNotFoundException if no Film found with the given id.
	 */
	Film delete(Integer filmIdInstance) throws EntityNotFoundException;

	/**
	 * Find all Films matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Films.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Film> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Films matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Films.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Film> findAll(String query, Pageable pageable);

    /**
	 * Exports all Films matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Films in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Film.
	 */
	long count(String query);

    /*
     * Returns the associated inventories for given Film id.
     *
     * @param filmId value of filmId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Inventory instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Inventory> findAssociatedInventories(Integer filmId, Pageable pageable);

    /*
     * Returns the associated filmActors for given Film id.
     *
     * @param filmId value of filmId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated FilmActor instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<FilmActor> findAssociatedFilmActors(Integer filmId, Pageable pageable);

}
