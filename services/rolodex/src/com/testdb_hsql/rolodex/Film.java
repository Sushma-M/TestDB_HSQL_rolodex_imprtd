/*Generated by WaveMaker Studio*/
package com.testdb_hsql.rolodex;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Film generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`FILM`", schema = "PUBLIC")
public class Film implements Serializable {

    private Integer filmId;
    private String title;
    private String description;
    private String releaseYear;
    private int rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private List<Inventory> inventories = new ArrayList<>();
    private List<FilmActor> filmActors = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`FILM_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getFilmId() {
        return this.filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Column(name = "`TITLE`", nullable = false, length = 255)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "`DESCRIPTION`", nullable = true, length = 500)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`RELEASE_YEAR`", nullable = true, length = 4)
    public String getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Column(name = "`RENTAL_DURATION`", nullable = false, scale = 0, precision = 10)
    public int getRentalDuration() {
        return this.rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Column(name = "`RENTAL_RATE`", nullable = false, scale = 2, precision = 4)
    public BigDecimal getRentalRate() {
        return this.rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Column(name = "`LENGTH`", nullable = true, scale = 0, precision = 10)
    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Column(name = "`REPLACEMENT_COST`", nullable = false, scale = 2, precision = 5)
    public BigDecimal getReplacementCost() {
        return this.replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Column(name = "`RATING`", nullable = true, length = 5)
    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Column(name = "`SPECIAL_FEATURES`", nullable = true, length = 60)
    public String getSpecialFeatures() {
        return this.specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "film")
    public List<Inventory> getInventories() {
        return this.inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "film")
    public List<FilmActor> getFilmActors() {
        return this.filmActors;
    }

    public void setFilmActors(List<FilmActor> filmActors) {
        this.filmActors = filmActors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        final Film film = (Film) o;
        return Objects.equals(getFilmId(), film.getFilmId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilmId());
    }
}

