/*Generated by WaveMaker Studio*/
package com.testdb_hsql.newprofilestest;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Table1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE1`")
public class Table1 implements Serializable {

    private Integer id;
    private String profilename;
    private Date dateofcreation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`profilename`", nullable = true, length = 255)
    public String getProfilename() {
        return this.profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`dateofcreation`", nullable = true)
    public Date getDateofcreation() {
        return this.dateofcreation;
    }

    public void setDateofcreation(Date dateofcreation) {
        this.dateofcreation = dateofcreation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table1)) return false;
        final Table1 table1 = (Table1) o;
        return Objects.equals(getId(), table1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

