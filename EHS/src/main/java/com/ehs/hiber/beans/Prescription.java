package com.ehs.hiber.beans;
// Generated Jan 23, 2011 11:50:14 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Prescription generated by hbm2java
 */
public class Prescription  implements java.io.Serializable {


     private int prescriptionId;
     private int id;
     private int visitNo;
     private String medrecno;
     private Date prescriptionDate;
     private Integer medicationId;
     private String dose;
     private String comments;
     private Integer injectionId;
     private String createdBy;
     private Date createdDate;
     private String updatedBy;
     private Date updatedDate;
     private int deleted;

    public Prescription() {
    }

	
    public Prescription(int prescriptionId, int id, int visitNo, String medrecno, Date prescriptionDate, String createdBy, Date createdDate, Date updatedDate, int deleted) {
        this.prescriptionId = prescriptionId;
        this.id = id;
        this.visitNo = visitNo;
        this.medrecno = medrecno;
        this.prescriptionDate = prescriptionDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.deleted = deleted;
    }
    public Prescription(int prescriptionId, int id, int visitNo, String medrecno, Date prescriptionDate, Integer medicationId, String dose, String comments, Integer injectionId, String createdBy, Date createdDate, String updatedBy, Date updatedDate, int deleted) {
       this.prescriptionId = prescriptionId;
       this.id = id;
       this.visitNo = visitNo;
       this.medrecno = medrecno;
       this.prescriptionDate = prescriptionDate;
       this.medicationId = medicationId;
       this.dose = dose;
       this.comments = comments;
       this.injectionId = injectionId;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.updatedBy = updatedBy;
       this.updatedDate = updatedDate;
       this.deleted = deleted;
    }
   
    public int getPrescriptionId() {
        return this.prescriptionId;
    }
    
    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getVisitNo() {
        return this.visitNo;
    }
    
    public void setVisitNo(int visitNo) {
        this.visitNo = visitNo;
    }
    public String getMedrecno() {
        return this.medrecno;
    }
    
    public void setMedrecno(String medrecno) {
        this.medrecno = medrecno;
    }
    public Date getPrescriptionDate() {
        return this.prescriptionDate;
    }
    
    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
    public Integer getMedicationId() {
        return this.medicationId;
    }
    
    public void setMedicationId(Integer medicationId) {
        this.medicationId = medicationId;
    }
    public String getDose() {
        return this.dose;
    }
    
    public void setDose(String dose) {
        this.dose = dose;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Integer getInjectionId() {
        return this.injectionId;
    }
    
    public void setInjectionId(Integer injectionId) {
        this.injectionId = injectionId;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public int getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }




}


