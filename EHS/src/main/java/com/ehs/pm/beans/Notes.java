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
    "notes"
})
@XmlRootElement(name = "Notes")
public class Notes extends MainBean{
    
    @XmlElement(required = false)
    private String notes;

    public Notes() {

    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFormattedNotes() {
        StringBuffer sb = new StringBuffer();
        sb.append(notes);
        sb.append("\n");
        sb.append("-----------------------------------------------------------");
        sb.append("\n");
        sb.append("Entered By :"+getEnteredBy() + " on: "+getEnteredDate());
        
        return sb.toString();
    }

}
