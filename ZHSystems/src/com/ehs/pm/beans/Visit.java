/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehs.pm.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author E15567
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "visitNo",
    "medRecNo",
    "visitDate",
    "drName",
    "comments",
    "height",
    "weight"
})
@XmlRootElement(name = "Visit")
public class Visit {

    @XmlElement(required = true)
    protected String visitNo;
    @XmlElement(required = true)
    protected String medRecNo;
    @XmlElement(required = true)
    protected String visitDate;
    @XmlElement(required = true)
    protected String drName;
    protected String comments;
    @XmlElement(required = true)
    protected String height;
    @XmlElement(required = true)
    protected String weight;

    public Visit() {
    }

    public String getHeight() {
        return height;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getVisitNo() {
        return visitNo;
    }

    public String getWeight() {
        return weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getComments() {
        return comments;
    }

    public String getDrName() {
        return drName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getMedRecNo() {
        return medRecNo;
    }

    public void setMedRecNo(String medRecNo) {
        this.medRecNo = medRecNo;
    }
}
