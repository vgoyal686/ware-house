/**
 * @author Anurag
 * @description 
 */
package com.example.bean;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import com.example.model.InputTxn;

/**
 * @author Anurag
 * @description 
 */
public class InputTxnLevelMappingBean {

  private int id;
  
  private boolean softDelete = false;

  
  /****************************  First Part from the Input Form  ****************************/
  
  
  private String customerID;

  private String warehouseID;

  private String orderID;

  
  /****************************  Second Part from the excel sheet  ****************************/
  
  private String level1Name;
  
  private String level1Value;
  
  private String level2Name;
  
  private String level2Value;
  
  private String level3Name;
  
  private String level3Value;

  /****************************** Third Part from the Input Txns ****************************/
  
  private int inputTxnId;

  /**
   * @author Anurag
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @author Anurag
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @author Anurag
   * @return the softDelete
   */
  public boolean isSoftDelete() {
    return softDelete;
  }

  /**
   * @author Anurag
   * @param softDelete the softDelete to set
   */
  public void setSoftDelete(boolean softDelete) {
    this.softDelete = softDelete;
  }

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
   * @return the warehouseID
   */
  public String getWarehouseID() {
    return warehouseID;
  }

  /**
   * @author Anurag
   * @param warehouseID the warehouseID to set
   */
  public void setWarehouseID(String warehouseID) {
    this.warehouseID = warehouseID;
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
   * @return the level1Value
   */
  public String getLevel1Value() {
    return level1Value;
  }

  /**
   * @author Anurag
   * @param level1Value the level1Value to set
   */
  public void setLevel1Value(String level1Value) {
    this.level1Value = level1Value;
  }

  /**
   * @author Anurag
   * @return the level2Name
   */
  public String getLevel2Name() {
    return level2Name;
  }

  /**
   * @author Anurag
   * @param level2Name the level2Name to set
   */
  public void setLevel2Name(String level2Name) {
    this.level2Name = level2Name;
  }

  /**
   * @author Anurag
   * @return the level2Value
   */
  public String getLevel2Value() {
    return level2Value;
  }

  /**
   * @author Anurag
   * @param level2Value the level2Value to set
   */
  public void setLevel2Value(String level2Value) {
    this.level2Value = level2Value;
  }

  /**
   * @author Anurag
   * @return the level3Name
   */
  public String getLevel3Name() {
    return level3Name;
  }

  /**
   * @author Anurag
   * @param level3Name the level3Name to set
   */
  public void setLevel3Name(String level3Name) {
    this.level3Name = level3Name;
  }

  /**
   * @author Anurag
   * @return the level3Value
   */
  public String getLevel3Value() {
    return level3Value;
  }

  /**
   * @author Anurag
   * @param level3Value the level3Value to set
   */
  public void setLevel3Value(String level3Value) {
    this.level3Value = level3Value;
  }

  /**
   * @author Anurag
   * @return the inputTxnId
   */
  public int getInputTxnId() {
    return inputTxnId;
  }

  /**
   * @author Anurag
   * @param inputTxnId the inputTxnId to set
   */
  public void setInputTxnId(int inputTxnId) {
    this.inputTxnId = inputTxnId;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "InputTxnLevelMappingBean [id=" + id + ", softDelete=" + softDelete + ", customerID="
        + customerID + ", warehouseID=" + warehouseID + ", orderID=" + orderID + ", level1Name="
        + level1Name + ", level1Value=" + level1Value + ", level2Name=" + level2Name
        + ", level2Value=" + level2Value + ", level3Name=" + level3Name + ", level3Value="
        + level3Value + ", inputTxnId=" + inputTxnId + "]";
  }

  /**
   * @param id
   * @param softDelete
   * @param customerID
   * @param warehouseID
   * @param orderID
   * @param level1Name
   * @param level1Value
   * @param level2Name
   * @param level2Value
   * @param level3Name
   * @param level3Value
   * @param inputTxnId
   */
  public InputTxnLevelMappingBean(int id, boolean softDelete, String customerID, String warehouseID,
      String orderID, String level1Name, String level1Value, String level2Name, String level2Value,
      String level3Name, String level3Value, int inputTxnId) {
    super();
    this.id = id;
    this.softDelete = softDelete;
    this.customerID = customerID;
    this.warehouseID = warehouseID;
    this.orderID = orderID;
    this.level1Name = level1Name;
    this.level1Value = level1Value;
    this.level2Name = level2Name;
    this.level2Value = level2Value;
    this.level3Name = level3Name;
    this.level3Value = level3Value;
    this.inputTxnId = inputTxnId;
  }
  
    
}
