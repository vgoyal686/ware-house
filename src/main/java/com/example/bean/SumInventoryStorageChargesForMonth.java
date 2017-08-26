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
public class SumInventoryStorageChargesForMonth {

  
  private String customerID;
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
   * @param storageCharges
   */
  public SumInventoryStorageChargesForMonth(String customerID, Double storageCharges) {
    super();
    this.customerID = customerID;
    this.storageCharges = storageCharges;
  }
  /**
   * 
   */
  public SumInventoryStorageChargesForMonth() {
    super();
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SumInventoryStorageChargesForMonth [customerID=" + customerID 
        + ", storageCharges=" + storageCharges + "]";
  }
  
  
}
