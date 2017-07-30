/**
 * @author Anurag
 * @description 
 */
package com.example.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedAttributeNode;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Anurag
 * @description 
 */
@Entity
@Table(name = "InputTxnLevelMapping")
@NamedEntityGraph(name = "InputTxnLevelMapping.detail",
attributeNodes = @NamedAttributeNode("inputTxn"))
public class InputTxnLevelMapping {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;
 
  @Column(name = "softDelete")
  private boolean softDelete = false;

//  @AttributeOverrides({
//    @AttributeOverride(name="identifierID", column = @Column(name="level1Value")),
//    @AttributeOverride(name="uom", column = @Column(name="level1Name"))
//  })
//  @EmbeddedId
//  Level1PK level1pk;
  
//  @OneToOne
//  @JoinColumns({
//    @JoinColumn(name="level1Value", referencedColumnName="identifierID"),
//    @JoinColumn(name="level1Name", referencedColumnName="uom")
//    })

  
  /****************************  First Part from the Input Form  ****************************/
  
  
  @Column(name = "customerID")
  private String customerID;

  @Column(name = "warehouseID")
  private String warehouseID;

  @Column(name = "orderID")
  private String orderID;

  
  /****************************  Second Part from the excel sheet  ****************************/
  
  //@Id
  @Column(name ="level1Name")
  private String level1Name;
  
  //@Id
  @Column(name ="level1Value")
  private String level1Value;

  //@MapsId
  @OneToOne//(fetch=FetchType.EAGER)//(mappedBy = "inputTxnLevelMapping")
  @JoinColumns({
  @JoinColumn(name="inputTxnId", referencedColumnName="id"),
  @JoinColumn(name="identifierID", referencedColumnName="identifierID"),
  @JoinColumn(name="uom", referencedColumnName="uom")
  //@JoinColumn(name="level1Value", referencedColumnName="identifierID"),
  //@JoinColumn(name="level1Name", referencedColumnName="uom")
  }) 
  InputTxn inputTxn;
  
  @Column(name ="level2Name")
  private String level2Name;
  
  @Column(name ="level2Value")
  private String level2Value;
  
  @Column(name ="level3Name")
  private String level3Name;
  
  @Column(name ="level3Value")
  private String level3Value;
  
  

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
   * @return the inputTxn
   */
  public InputTxn getInputTxn() {
    return inputTxn;
  }

  /**
   * @author Anurag
   * @param inputTxn the inputTxn to set
   */
  public void setInputTxn(InputTxn inputTxn) {
    this.inputTxn = inputTxn;
  }

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
    //return inputTxn.getUom();
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
    //return inputTxn.getIdentifierID();
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
   * @param customerID
   * @param warehouseID
   * @param orderID
   * @param level1Name
   * @param level1Value
   * @param level2Name
   * @param level2Value
   * @param level3Name
   * @param level3Value
   */
  public InputTxnLevelMapping(String customerID, String warehouseID, String orderID,
      String level1Name, String level1Value, String level2Name, String level2Value,
      String level3Name, String level3Value) {
    super();
    this.customerID = customerID;
    this.warehouseID = warehouseID;
    this.orderID = orderID;
    this.level1Name = level1Name;
    this.level1Value = level1Value;
    this.level2Name = level2Name;
    this.level2Value = level2Value;
    this.level3Name = level3Name;
    this.level3Value = level3Value;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "InputTxnLevelMapping [id=" + id + ", softDelete=" + softDelete + ", customerID="
        + customerID + ", warehouseID=" + warehouseID + ", orderID=" + orderID + ", level1Name="
        + level1Name + ", level1Value=" + level1Value + ", inputTxn=" + inputTxn + ", level2Name="
        + level2Name + ", level2Value=" + level2Value + ", level3Name=" + level3Name
        + ", level3Value=" + level3Value + "]";
  }

  /**
   * 
   */
  public InputTxnLevelMapping() {
    super();
  }
  
  
}
