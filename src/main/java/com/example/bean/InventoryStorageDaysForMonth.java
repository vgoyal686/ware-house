/**
 * @author Anurag
 * @description 
 */
package com.example.bean;

import java.util.Date;

/**
 * @author Anurag
 * @description 
 */
public class InventoryStorageDaysForMonth {

  private String customerID;
  private String orderID;
  private String uom;
  private String identifierID;
  private Date inDateTime;
  private Date outDateTime;
  private Integer daysPresent;
  private Double ratePerUnitPerDay;
  private Double storageCharges;
  /**
   * @author Anurag
   * @return the customerID
   */
  public String getCustomerID() {
    return customerID;
  }
  /**
   * @author Anurag
   * @param customerID the customerID to set
   */
  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }
  
  /**
   * @author Anurag
   * @return the orderID
   */
  public String getOrderID() {
    return orderID;
  }
  /**
   * @author Anurag
   * @param orderID the orderID to set
   */
  public void setOrderID(String orderID) {
    this.orderID = orderID;
  }
  /**
   * @author Anurag
   * @return the uom
   */
  public String getUom() {
    return uom;
  }
  /**
   * @author Anurag
   * @param uom the uom to set
   */
  public void setUom(String uom) {
    this.uom = uom;
  }
  /**
   * @author Anurag
   * @return the identifierID
   */
  public String getIdentifierID() {
    return identifierID;
  }
  /**
   * @author Anurag
   * @param identifierID the identifierID to set
   */
  public void setIdentifierID(String identifierID) {
    this.identifierID = identifierID;
  }
  /**
   * @author Anurag
   * @return the inDateTime
   */
  public Date getInDateTime() {
    return inDateTime;
  }
  /**
   * @author Anurag
   * @param inDateTime the inDateTime to set
   */
  public void setInDateTime(Date inDateTime) {
    this.inDateTime = inDateTime;
  }
  /**
   * @author Anurag
   * @return the outDateTime
   */
  public Date getOutDateTime() {
    return outDateTime;
  }
  /**
   * @author Anurag
   * @param outDateTime the outDateTime to set
   */
  public void setOutDateTime(Date outDateTime) {
    this.outDateTime = outDateTime;
  }
  /**
   * @author Anurag
   * @return the daysPresent
   */
  public Integer getDaysPresent() {
    return daysPresent;
  }
  /**
   * @author Anurag
   * @param daysPresent the daysPresent to set
   */
  public void setDaysPresent(Integer daysPresent) {
    this.daysPresent = daysPresent;
  }

  /**
   * @author Anurag
   * @return the ratePerUnitPerDay
   */
  public Double getRatePerUnitPerDay() {
    return ratePerUnitPerDay;
  }
  /**
   * @author Anurag
   * @param ratePerUnitPerDay the ratePerUnitPerDay to set
   */
  public void setRatePerUnitPerDay(Double ratePerUnitPerDay) {
    this.ratePerUnitPerDay = ratePerUnitPerDay;
  }
  /**
   * @author Anurag
   * @return the storageCharges
   */
  public Double getStorageCharges() {
    return storageCharges;
  }
  /**
   * @author Anurag
   * @param storageCharges the storageCharges to set
   */
  public void setStorageCharges(Double storageCharges) {
    this.storageCharges = storageCharges;
  }
  /**
   * @param customerID
   * @param orderID
   * @param uom
   * @param identifierID
   * @param inDateTime
   * @param outDateTime
   * @param daysPresent
   */
  public InventoryStorageDaysForMonth(String customerID, String orderID, String uom,
      String identifierID, Date inDateTime, Date outDateTime, Integer daysPresent) {
    super();
    this.customerID = customerID;
    this.orderID = orderID;
    this.uom = uom;
    this.identifierID = identifierID;
    this.inDateTime = inDateTime;
    this.outDateTime = outDateTime;
    this.daysPresent = daysPresent;
  }
  /**
   * 
   */
  public InventoryStorageDaysForMonth() {
    super();
  }
  
  /**
   * @param customerID
   * @param uom
   * @param identifierID
   * @param inDateTime
   */
  public InventoryStorageDaysForMonth(String customerID, String uom, String identifierID) {
    this.customerID = customerID;
    this.uom = uom;
    this.identifierID = identifierID;
   
  }
  
  
  
}
