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
    "medRecNo"
})
@XmlRootElement(name = "MainBean")
public class MainBean extends AuditBean{
	
    @XmlElement(required = true)
    private String visitNo;
    @XmlElement(required = true)
    private String medRecNo;

    public MainBean() {
    	
    }

    public void setMedRecNo(String medRecNo) {
        this.medRecNo = medRecNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }

    public String getMedRecNo() {
        return medRecNo;
    }

    public String getVisitNo() {
        return visitNo;
    }

}
