package com.ehs.hiber.beans;
// Generated Oct 2, 2010 7:12:40 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Huser generated by hbm2java
 */
public class Huser  implements java.io.Serializable {


     private String userid;
     private String password;
     private String firstName;
     private String lastName;
     private char active;
     private int roleId;
     private int deleted;
     private String createdUser;
     private Date createdDate;
     private String lastUpdatedUser;
     private Date lastUpdatedDate;

    public Huser() {
    }

	
    public Huser(String userid, String password, String firstName, String lastName, char active, int roleId, int deleted, String createdUser, Date createdDate, Date lastUpdatedDate) {
        this.userid = userid;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.roleId = roleId;
        this.deleted = deleted;
        this.createdUser = createdUser;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public Huser(String userid, String password, String firstName, String lastName, char active, int roleId, int deleted, String createdUser, Date createdDate, String lastUpdatedUser, Date lastUpdatedDate) {
       this.userid = userid;
       this.password = password;
       this.firstName = firstName;
       this.lastName = lastName;
       this.active = active;
       this.roleId = roleId;
       this.deleted = deleted;
       this.createdUser = createdUser;
       this.createdDate = createdDate;
       this.lastUpdatedUser = lastUpdatedUser;
       this.lastUpdatedDate = lastUpdatedDate;
    }
   
    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public char getActive() {
        return this.active;
    }
    
    public void setActive(char active) {
        this.active = active;
    }
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public int getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    public String getCreatedUser() {
        return this.createdUser;
    }
    
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getLastUpdatedUser() {
        return this.lastUpdatedUser;
    }
    
    public void setLastUpdatedUser(String lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }




}


