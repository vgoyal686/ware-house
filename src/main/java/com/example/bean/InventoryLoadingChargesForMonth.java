/**
 * @author Anurag
 * @description 
 */
package com.example.bean;

import java.util.Date;

import javax.persistence.Column;

/**
 * @author Anurag
 * @description 
 */
public class InventoryLoadingChargesForMonth {
  
  private String customerID;
  private int orderID;
  private String uom;
  private Date orderDate;
  private String loadingCharge;
  private String unloadingCharge;
  private String otherCharge;
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
  public int getOrderID() {
    return orderID;
  }
  /**
   * @author Anurag
   * @param orderID the orderID to set
   */
  public void setOrderID(int orderID) {
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
   * @return the orderDate
   */
  public Date getOrderDate() {
    return orderDate;
  }
  /**
   * @author Anurag
   * @param orderDate the orderDate to set
   */
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }
  /**
   * @author Anurag
   * @return the loadingCharge
   */
  public String getLoadingCharge() {
    return loadingCharge;
  }
  /**
   * @author Anurag
   * @param loadingCharge the loadingCharge to set
   */
  public void setLoadingCharge(String loadingCharge) {
    this.loadingCharge = loadingCharge;
  }
  /**
   * @author Anurag
   * @return the unloadingCharge
   */
  public String getUnloadingCharge() {
    return unloadingCharge;
  }
  /**
   * @author Anurag
   * @param unloadingCharge the unloadingCharge to set
   */
  public void setUnloadingCharge(String unloadingCharge) {
    this.unloadingCharge = unloadingCharge;
  }
  /**
   * @author Anurag
   * @return the otherCharge
   */
  public String getOtherCharge() {
    return otherCharge;
  }
  /**
   * @author Anurag
   * @param otherCharge the otherCharge to set
   */
  public void setOtherCharge(String otherCharge) {
    this.otherCharge = otherCharge;
  }
  /**
   * @param customerID
   * @param orderID
   * @param uom
   * @param orderDate
   * @param loadingCharge
   * @param unloadingCharge
   * @param otherCharge
   */
  public InventoryLoadingChargesForMonth(String customerID, int orderID, String uom,
      Date orderDate, String loadingCharge, String unloadingCharge, String otherCharge) {
    super();
    this.customerID = customerID;
    this.orderID = orderID;
    this.uom = uom;
    this.orderDate = orderDate;
    this.loadingCharge = loadingCharge;
    this.unloadingCharge = unloadingCharge;
    this.otherCharge = otherCharge;
  }
  /**
   * 
   */
  public InventoryLoadingChargesForMonth() {
    super();
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "InventoryLoadingChargesForMonth [customerID=" + customerID + ", orderID=" + orderID
        + ", uom=" + uom + ", orderDate=" + orderDate + ", loadingCharge=" + loadingCharge
        + ", unloadingCharge=" + unloadingCharge + ", otherCharge=" + otherCharge + "]";
  }

  
}
