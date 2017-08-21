/**
 * @author Anurag
 * @description 
 */
package com.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.model.Level1PK;

/**
 * @author Anurag
 * @description 
 */
@Entity
@Table(name = "InputTxn")
//@IdClass(Level1PK.class)
public class InputTxn implements java.io.Serializable{

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;
  
  @Column(name = "softDelete")
  private boolean softDelete = false;
 
  @Temporal(TemporalType.TIMESTAMP)
  private Date inDateTime;
  @Temporal(TemporalType.TIMESTAMP)
  private Date outDateTime;

  @Column(name = "outDate")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.TIMESTAMP)
  private Date outDate;
  
  
  @PrePersist
  protected void onCreate() {
      inDateTime = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
      outDateTime = new Date();
  } 

  //@OneToOne(optional=true)//(cascade = CascadeType.ALL)
  //@PrimaryKeyJoinColumn

//  @OneToOne(optional=true)
//  @JoinColumns ({
//    @JoinColumn(name="level2Value", referencedColumnName="level2Value"),
//    @JoinColumn(name="level2Name", referencedColumnName="level2Name")
//  })
//  private InputTxnLevelMapping inputTxnLevelMapping;
  


  /****************************  First Part from the Input Form  ****************************/
  
  
  @Column(name = "customerID")
  private String customerID;

  @Column(name = "warehouseID")
  private String warehouseID;

  @Column(name = "orderID")
  private String orderID;

  @Column(name = "outOrderID")
  private String outOrderID;
  
  @Column(name = "invoiceNo")
  private String invoiceNo;

  @Column(name = "invoiceDate")
  private String invoiceDate;

  @Column(name = "lCNo")
  private String lCNo;

  @Column(name = "dateOfIssue")
  private String dateOfIssue;

  @Column(name = "customer")
  private String customer;

  @Column(name = "deliveryTerms")
  private String deliveryTerms;

  @Column(name = "portOfImport")
  private String portOfImport;

  @Column(name = "bLNo")
  private String bLNo;

  @Column(name = "bLDate")
  private String bLDate;

  @Column(name = "pONo")
  private String pONo;

  @Column(name = "comments")
  private String comments;

  
  /****************************  Second Part from the excel sheet  ****************************/
  @Column(name = "category")
  private String category;

  @Column(name = "subCategory")
  private String subCategory;

  @Column(name = "product")
  private String product;

  @Column(name = "principalCompany")
  private String principalCompany;

  @Column(name = "model")
  private String model;

  //@Id
  @Column(name = "identifierID")
  private String identifierID;
  
  //@Id
  @Column(name = "uom")
  private String uom;

  @Column(name = "quantity")
  private String quantity;

  @Column(name = "attribute1Name")
  private String attribute1Name;

  @Column(name = "attribute1Value")
  private String attribute1Value;

  @Column(name = "attribute2Name")
  private String attribute2Name;

  @Column(name = "attribute2Value")
  private String attribute2Value;

  @Column(name = "attribute3Name")
  private String attribute3Name;

  @Column(name = "attribute3Value")
  private String attribute3Value;

  @Column(name = "attribute4Name")
  private String attribute4Name;

  @Column(name = "attribute4Value")
  private String attribute4Value;

  @Column(name = "attribute5Name")
  private String attribute5Name;

  @Column(name = "attribute5Value")
  private String attribute5Value;

  @Column(name = "description")
  private String description;

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
   * @return the invoiceNo
   */
  public String getInvoiceNo() {
    return invoiceNo;
  }

  /**
   * @author Anurag
   * @param invoiceNo the invoiceNo to set
   */
  public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
  }

  /**
   * @author Anurag
   * @return the invoiceDate
   */
  public String getInvoiceDate() {
    return invoiceDate;
  }

  /**
   * @author Anurag
   * @param invoiceDate the invoiceDate to set
   */
  public void setInvoiceDate(String invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  /**
   * @author Anurag
   * @return the lCNo
   */
  public String getlCNo() {
    return lCNo;
  }

  /**
   * @author Anurag
   * @param lCNo the lCNo to set
   */
  public void setlCNo(String lCNo) {
    this.lCNo = lCNo;
  }

  /**
   * @author Anurag
   * @return the dateOfIssue
   */
  public String getDateOfIssue() {
    return dateOfIssue;
  }

  /**
   * @author Anurag
   * @param dateOfIssue the dateOfIssue to set
   */
  public void setDateOfIssue(String dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }

  /**
   * @author Anurag
   * @return the customer
   */
  public String getCustomer() {
    return customer;
  }

  /**
   * @author Anurag
   * @param customer the customer to set
   */
  public void setCustomer(String customer) {
    this.customer = customer;
  }

  /**
   * @author Anurag
   * @return the deliveryTerms
   */
  public String getDeliveryTerms() {
    return deliveryTerms;
  }

  /**
   * @author Anurag
   * @param deliveryTerms the deliveryTerms to set
   */
  public void setDeliveryTerms(String deliveryTerms) {
    this.deliveryTerms = deliveryTerms;
  }

  /**
   * @author Anurag
   * @return the portOfImport
   */
  public String getPortOfImport() {
    return portOfImport;
  }

  /**
   * @author Anurag
   * @param portOfImport the portOfImport to set
   */
  public void setPortOfImport(String portOfImport) {
    this.portOfImport = portOfImport;
  }

  /**
   * @author Anurag
   * @return the bLNo
   */
  public String getbLNo() {
    return bLNo;
  }

  /**
   * @author Anurag
   * @param bLNo the bLNo to set
   */
  public void setbLNo(String bLNo) {
    this.bLNo = bLNo;
  }

  /**
   * @author Anurag
   * @return the bLDate
   */
  public String getbLDate() {
    return bLDate;
  }

  /**
   * @author Anurag
   * @param bLDate the bLDate to set
   */
  public void setbLDate(String bLDate) {
    this.bLDate = bLDate;
  }

  /**
   * @author Anurag
   * @return the pONo
   */
  public String getpONo() {
    return pONo;
  }

  /**
   * @author Anurag
   * @param pONo the pONo to set
   */
  public void setpONo(String pONo) {
    this.pONo = pONo;
  }

  /**
   * @author Anurag
   * @return the comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * @author Anurag
   * @param comments the comments to set
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  /**
   * @author Anurag
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * @author Anurag
   * @param category the category to set
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * @author Anurag
   * @return the subCategory
   */
  public String getSubCategory() {
    return subCategory;
  }

  /**
   * @author Anurag
   * @param subCategory the subCategory to set
   */
  public void setSubCategory(String subCategory) {
    this.subCategory = subCategory;
  }

  /**
   * @author Anurag
   * @return the product
   */
  public String getProduct() {
    return product;
  }

  /**
   * @author Anurag
   * @param product the product to set
   */
  public void setProduct(String product) {
    this.product = product;
  }

  /**
   * @author Anurag
   * @return the principalCompany
   */
  public String getPrincipalCompany() {
    return principalCompany;
  }

  /**
   * @author Anurag
   * @param principalCompany the principalCompany to set
   */
  public void setPrincipalCompany(String principalCompany) {
    this.principalCompany = principalCompany;
  }

  /**
   * @author Anurag
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * @author Anurag
   * @param model the model to set
   */
  public void setModel(String model) {
    this.model = model;
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
   * @return the quantity
   */
  public String getQuantity() {
    return quantity;
  }

  /**
   * @author Anurag
   * @param quantity the quantity to set
   */
  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  /**
   * @author Anurag
   * @return the attribute1Name
   */
  public String getAttribute1Name() {
    return attribute1Name;
  }

  /**
   * @author Anurag
   * @param attribute1Name the attribute1Name to set
   */
  public void setAttribute1Name(String attribute1Name) {
    this.attribute1Name = attribute1Name;
  }

  /**
   * @author Anurag
   * @return the attribute1Value
   */
  public String getAttribute1Value() {
    return attribute1Value;
  }

  /**
   * @author Anurag
   * @param attribute1Value the attribute1Value to set
   */
  public void setAttribute1Value(String attribute1Value) {
    this.attribute1Value = attribute1Value;
  }

  /**
   * @author Anurag
   * @return the attribute2Name
   */
  public String getAttribute2Name() {
    return attribute2Name;
  }

  /**
   * @author Anurag
   * @param attribute2Name the attribute2Name to set
   */
  public void setAttribute2Name(String attribute2Name) {
    this.attribute2Name = attribute2Name;
  }

  /**
   * @author Anurag
   * @return the attribute2Value
   */
  public String getAttribute2Value() {
    return attribute2Value;
  }

  /**
   * @author Anurag
   * @param attribute2Value the attribute2Value to set
   */
  public void setAttribute2Value(String attribute2Value) {
    this.attribute2Value = attribute2Value;
  }

  /**
   * @author Anurag
   * @return the attribute3Name
   */
  public String getAttribute3Name() {
    return attribute3Name;
  }

  /**
   * @author Anurag
   * @param attribute3Name the attribute3Name to set
   */
  public void setAttribute3Name(String attribute3Name) {
    this.attribute3Name = attribute3Name;
  }

  /**
   * @author Anurag
   * @return the attribute3Value
   */
  public String getAttribute3Value() {
    return attribute3Value;
  }

  /**
   * @author Anurag
   * @param attribute3Value the attribute3Value to set
   */
  public void setAttribute3Value(String attribute3Value) {
    this.attribute3Value = attribute3Value;
  }

  /**
   * @author Anurag
   * @return the attribute4Name
   */
  public String getAttribute4Name() {
    return attribute4Name;
  }

  /**
   * @author Anurag
   * @param attribute4Name the attribute4Name to set
   */
  public void setAttribute4Name(String attribute4Name) {
    this.attribute4Name = attribute4Name;
  }

  /**
   * @author Anurag
   * @return the attribute4Value
   */
  public String getAttribute4Value() {
    return attribute4Value;
  }

  /**
   * @author Anurag
   * @param attribute4Value the attribute4Value to set
   */
  public void setAttribute4Value(String attribute4Value) {
    this.attribute4Value = attribute4Value;
  }

  /**
   * @author Anurag
   * @return the attribute5Name
   */
  public String getAttribute5Name() {
    return attribute5Name;
  }

  /**
   * @author Anurag
   * @param attribute5Name the attribute5Name to set
   */
  public void setAttribute5Name(String attribute5Name) {
    this.attribute5Name = attribute5Name;
  }

  /**
   * @author Anurag
   * @return the attribute5Value
   */
  public String getAttribute5Value() {
    return attribute5Value;
  }

  /**
   * @author Anurag
   * @param attribute5Value the attribute5Value to set
   */
  public void setAttribute5Value(String attribute5Value) {
    this.attribute5Value = attribute5Value;
  }

  /**
   * @author Anurag
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @author Anurag
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }
  

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "InputTxn [id=" + id + ", softDelete=" + softDelete + ", customerID=" + customerID
        + ", warehouseID=" + warehouseID + ", orderID=" + orderID + ", invoiceNo=" + invoiceNo
        + ", invoiceDate=" + invoiceDate + ", lCNo=" + lCNo + ", dateOfIssue=" + dateOfIssue
        + ", customer=" + customer + ", deliveryTerms=" + deliveryTerms + ", portOfImport="
        + portOfImport + ", bLNo=" + bLNo + ", bLDate=" + bLDate + ", pONo=" + pONo + ", comments="
        + comments + ", category=" + category + ", subCategory=" + subCategory + ", product="
        + product + ", principalCompany=" + principalCompany + ", model=" + model
        + ", identifierID=" + identifierID + ", uom=" + uom + ", quantity=" + quantity
        + ", attribute1Name=" + attribute1Name + ", attribute1Value=" + attribute1Value
        + ", attribute2Name=" + attribute2Name + ", attribute2Value=" + attribute2Value
        + ", attribute3Name=" + attribute3Name + ", attribute3Value=" + attribute3Value
        + ", attribute4Name=" + attribute4Name + ", attribute4Value=" + attribute4Value
        + ", attribute5Name=" + attribute5Name + ", attribute5Value=" + attribute5Value
        + ", description=" + description + "]";
  }

  /**
   * @param id
   * @param customerID
   * @param warehouseID
   * @param orderID
   * @param invoiceNo
   * @param invoiceDate
   * @param lCNo
   * @param dateOfIssue
   * @param customer
   * @param deliveryTerms
   * @param portOfImport
   * @param bLNo
   * @param bLDate
   * @param pONo
   * @param comments
   * @param category
   * @param subCategory
   * @param product
   * @param principalCompany
   * @param model
   * @param identifierID
   * @param uom
   * @param quantity
   * @param attribute1Name
   * @param attribute1Value
   * @param attribute2Name
   * @param attribute2Value
   * @param attribute3Name
   * @param attribute3Value
   * @param attribute4Name
   * @param attribute4Value
   * @param attribute5Name
   * @param attribute5Value
   * @param description
   */
  public InputTxn(String customerID, String warehouseID, String orderID, String invoiceNo,
      String invoiceDate, String lCNo, String dateOfIssue, String customer, String deliveryTerms,
      String portOfImport, String bLNo, String bLDate, String pONo, String comments,
      String category, String subCategory, String product, String principalCompany, String model,
      String identifierID, String uom, String quantity, String attribute1Name,
      String attribute1Value, String attribute2Name, String attribute2Value, String attribute3Name,
      String attribute3Value, String attribute4Name, String attribute4Value, String attribute5Name,
      String attribute5Value, String description) {
    super();
    this.id = id;
    this.customerID = customerID;
    this.warehouseID = warehouseID;
    this.orderID = orderID;
    this.invoiceNo = invoiceNo;
    this.invoiceDate = invoiceDate;
    this.lCNo = lCNo;
    this.dateOfIssue = dateOfIssue;
    this.customer = customer;
    this.deliveryTerms = deliveryTerms;
    this.portOfImport = portOfImport;
    this.bLNo = bLNo;
    this.bLDate = bLDate;
    this.pONo = pONo;
    this.comments = comments;
    this.category = category;
    this.subCategory = subCategory;
    this.product = product;
    this.principalCompany = principalCompany;
    this.model = model;
    this.identifierID = identifierID;
    this.uom = uom;
    this.quantity = quantity;
    this.attribute1Name = attribute1Name;
    this.attribute1Value = attribute1Value;
    this.attribute2Name = attribute2Name;
    this.attribute2Value = attribute2Value;
    this.attribute3Name = attribute3Name;
    this.attribute3Value = attribute3Value;
    this.attribute4Name = attribute4Name;
    this.attribute4Value = attribute4Value;
    this.attribute5Name = attribute5Name;
    this.attribute5Value = attribute5Value;
    this.description = description;
  }

  /**
   * @param id
   * @param softDelete
   * @param customerID
   * @param warehouseID
   * @param orderID
   * @param invoiceNo
   * @param invoiceDate
   * @param lCNo
   * @param dateOfIssue
   * @param customer
   * @param deliveryTerms
   * @param portOfImport
   * @param bLNo
   * @param bLDate
   * @param pONo
   * @param comments
   * @param category
   * @param subCategory
   * @param product
   * @param principalCompany
   * @param model
   * @param identifierID
   * @param uom
   * @param quantity
   * @param attribute1Name
   * @param attribute1Value
   * @param attribute2Name
   * @param attribute2Value
   * @param attribute3Name
   * @param attribute3Value
   * @param attribute4Name
   * @param attribute4Value
   * @param attribute5Name
   * @param attribute5Value
   * @param description
   */
  public InputTxn(int id, boolean softDelete, String customerID, String warehouseID, String orderID,
      String invoiceNo, String invoiceDate, String lCNo, String dateOfIssue, String customer,
      String deliveryTerms, String portOfImport, String bLNo, String bLDate, String pONo,
      String comments, String category, String subCategory, String product, String principalCompany,
      String model, String identifierID, String uom, String quantity, String attribute1Name,
      String attribute1Value, String attribute2Name, String attribute2Value, String attribute3Name,
      String attribute3Value, String attribute4Name, String attribute4Value, String attribute5Name,
      String attribute5Value, String description) {
    this.id = id;
    this.softDelete = softDelete;
    this.customerID = customerID;
    this.warehouseID = warehouseID;
    this.orderID = orderID;
    this.invoiceNo = invoiceNo;
    this.invoiceDate = invoiceDate;
    this.lCNo = lCNo;
    this.dateOfIssue = dateOfIssue;
    this.customer = customer;
    this.deliveryTerms = deliveryTerms;
    this.portOfImport = portOfImport;
    this.bLNo = bLNo;
    this.bLDate = bLDate;
    this.pONo = pONo;
    this.comments = comments;
    this.category = category;
    this.subCategory = subCategory;
    this.product = product;
    this.principalCompany = principalCompany;
    this.model = model;
    this.identifierID = identifierID;
    this.uom = uom;
    this.quantity = quantity;
    this.attribute1Name = attribute1Name;
    this.attribute1Value = attribute1Value;
    this.attribute2Name = attribute2Name;
    this.attribute2Value = attribute2Value;
    this.attribute3Name = attribute3Name;
    this.attribute3Value = attribute3Value;
    this.attribute4Name = attribute4Name;
    this.attribute4Value = attribute4Value;
    this.attribute5Name = attribute5Name;
    this.attribute5Value = attribute5Value;
    this.description = description;
  }
 
  public InputTxn() {}

  /**
   * @author Anurag
   * @return the outOrderID
   */
  public String getOutOrderID() {
    return outOrderID;
  }

  /**
   * @author Anurag
   * @param outOrderID the outOrderID to set
   */
  public void setOutOrderID(String outOrderID) {
    this.outOrderID = outOrderID;
  }

  /**
   * @author Anurag
   * @return the outDate
   */
  public Date getOutDate() {
    return outDate;
  }

  /**
   * @author Anurag
   * @param outDate the outDate to set
   */
  public void setOutDate(Date outDate) {
    this.outDate = outDate;
  }


  public InputTxn(int id, boolean softDelete, Date outDate, String customerID, String warehouseID,
      String orderID, String outOrderID, String invoiceNo, String invoiceDate, String lCNo,
      String dateOfIssue, String customer, String deliveryTerms, String portOfImport, String bLNo,
      String bLDate, String pONo, String comments, String category, String subCategory,
      String product, String principalCompany, String model, String identifierID, String uom,
      String quantity, String attribute1Name, String attribute1Value, String attribute2Name,
      String attribute2Value, String attribute3Name, String attribute3Value, String attribute4Name,
      String attribute4Value, String attribute5Name, String attribute5Value, String description) {
    super();
    this.id = id;
    this.softDelete = softDelete;
    this.outDate = outDate;
    this.customerID = customerID;
    this.warehouseID = warehouseID;
    this.orderID = orderID;
    this.outOrderID = outOrderID;
    this.invoiceNo = invoiceNo;
    this.invoiceDate = invoiceDate;
    this.lCNo = lCNo;
    this.dateOfIssue = dateOfIssue;
    this.customer = customer;
    this.deliveryTerms = deliveryTerms;
    this.portOfImport = portOfImport;
    this.bLNo = bLNo;
    this.bLDate = bLDate;
    this.pONo = pONo;
    this.comments = comments;
    this.category = category;
    this.subCategory = subCategory;
    this.product = product;
    this.principalCompany = principalCompany;
    this.model = model;
    this.identifierID = identifierID;
    this.uom = uom;
    this.quantity = quantity;
    this.attribute1Name = attribute1Name;
    this.attribute1Value = attribute1Value;
    this.attribute2Name = attribute2Name;
    this.attribute2Value = attribute2Value;
    this.attribute3Name = attribute3Name;
    this.attribute3Value = attribute3Value;
    this.attribute4Name = attribute4Name;
    this.attribute4Value = attribute4Value;
    this.attribute5Name = attribute5Name;
    this.attribute5Value = attribute5Value;
    this.description = description;
  }

  
}
