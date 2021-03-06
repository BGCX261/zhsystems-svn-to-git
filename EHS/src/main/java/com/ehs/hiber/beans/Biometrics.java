package com.ehs.hiber.beans;
// Generated Jan 23, 2011 11:50:14 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Biometrics generated by hbm2java
 */
public class Biometrics  implements java.io.Serializable {


     private int id;
     private String medrecno;
     private int visitNo;
     private Float height;
     private Float weight;
     private Integer age;
     private int deleted;
     private String createdBy;
     private Date createdDate;
     private String updatedBy;
     private Date updatedDate;

    public Biometrics() {
    }

	
    public Biometrics(int id, String medrecno, int visitNo, int deleted, String createdBy, Date createdDate, Date updatedDate) {
        this.id = id;
        this.medrecno = medrecno;
        this.visitNo = visitNo;
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
    public Biometrics(int id, String medrecno, int visitNo, Float height, Float weight, Integer age, int deleted, String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
       this.id = id;
       this.medrecno = medrecno;
       this.visitNo = visitNo;
       this.height = height;
       this.weight = weight;
       this.age = age;
       this.deleted = deleted;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.updatedBy = updatedBy;
       this.updatedDate = updatedDate;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getMedrecno() {
        return this.medrecno;
    }
    
    public void setMedrecno(String medrecno) {
        this.medrecno = medrecno;
    }
    public int getVisitNo() {
        return this.visitNo;
    }
    
    public void setVisitNo(int visitNo) {
        this.visitNo = visitNo;
    }
    public Float getHeight() {
        return this.height;
    }
    
    public void setHeight(Float height) {
        this.height = height;
    }
    public Float getWeight() {
        return this.weight;
    }
    
    public void setWeight(Float weight) {
        this.weight = weight;
    }
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    public int getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(int deleted) {
        this.deleted = deleted;
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




}


