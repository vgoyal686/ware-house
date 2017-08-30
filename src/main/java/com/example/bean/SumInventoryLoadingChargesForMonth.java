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
public class SumInventoryLoadingChargesForMonth {

  private String customerID;
  private Double loadingCharge;
  private Double unloadingCharge;
  private Double otherCharge;
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
   * @return the loadingCharge
   */
  public Double getLoadingCharge() {
    return loadingCharge;
  }
  /**
   * @author Anurag
   * @param loadingCharge the loadingCharge to set
   */
  public void setLoadingCharge(Double loadingCharge) {
    this.loadingCharge = loadingCharge;
  }
  /**
   * @author Anurag
   * @return the unloadingCharge
   */
  public Double getUnloadingCharge() {
    return unloadingCharge;
  }
  /**
   * @author Anurag
   * @param unloadingCharge the unloadingCharge to set
   */
  public void setUnloadingCharge(Double unloadingCharge) {
    this.unloadingCharge = unloadingCharge;
  }
  /**
   * @author Anurag
   * @return the otherCharge
   */
  public Double getOtherCharge() {
    return otherCharge;
  }
  /**
   * @author Anurag
   * @param otherCharge the otherCharge to set
   */
  public void setOtherCharge(Double otherCharge) {
    this.otherCharge = otherCharge;
  }
  /**
   * @param customerID
   * @param loadingCharge
   * @param unloadingCharge
   * @param otherCharge
   */
  public SumInventoryLoadingChargesForMonth(String customerID, Double loadingCharge,
      Double unloadingCharge, Double otherCharge) {
    super();
    this.customerID = customerID;
    this.loadingCharge = loadingCharge;
    this.unloadingCharge = unloadingCharge;
    this.otherCharge = otherCharge;
  }
  /**
   * 
   */
  public SumInventoryLoadingChargesForMonth() {
    super();
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SumInventoryLoadingChargesForMonth [customerID=" + customerID + ", loadingCharge="
        + loadingCharge + ", unloadingCharge=" + unloadingCharge + ", otherCharge=" + otherCharge
        + "]";
  }

  
  
}
