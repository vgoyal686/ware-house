package com.example.bean;

/**
 * @author Anurag
 * @description 
 */
public class InventoryLeftInWarehouses {

  private String customerID;
  private String level1Name;
  private Long level1Count;
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
   * @return the level1Name
   */
  public String getLevel1Name() {
    return level1Name;
  }
  /**
   * @author Anurag
   * @param level1Name the level1Name to set
   */
  public void setLevel1Name(String level1Name) {
    this.level1Name = level1Name;
  }
  /**
   * @author Anurag
   * @return the level1Count
   */
  public Long getLevel1Count() {
    return level1Count;
  }
  /**
   * @author Anurag
   * @param level1Count the level1Count to set
   */
  public void setLevel1Count(Long level1Count) {
    this.level1Count = level1Count;
  }
  
  /**
   * @param customerID
   * @param level1Name
   * @param level1Count
   */
  public InventoryLeftInWarehouses(String customerID, String level1Name, Long level1Count) {
    super();
    this.customerID = customerID;
    this.level1Name = level1Name;
    this.level1Count = level1Count;
  }
  
}
