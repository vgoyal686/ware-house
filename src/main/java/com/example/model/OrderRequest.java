/**
 * @author Anurag
 * @description 
 */
package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Anurag
 * @description 
 */
@Entity
@Table(name = "OrderRequest")
public class OrderRequest {

  @Column(name = "customerID")
  //@NotEmpty(message = "Please provide your customerID")
  private String customerID;

  @Column(name = "orderID")
  //@NotEmpty(message = "Please provide your orderID")
  private String orderID;

  @Column(name = "orderDate")
  //@NotEmpty(message = "Please provide your orderDate")
  private String orderDate;

  @Column(name = "warehouseID")
  //@NotEmpty(message = "Please provide your warehouseID")
  private String warehouseID;

  @Column(name = "currentUnit")
  //@NotEmpty(message = "Please provide your currentUnit")
  private String currentUnit;

  @Column(name = "currentStock")
  //@NotEmpty(message = "Please provide your currentStock")
  private String currentStock;

  @Column(name = "details")
  //@NotEmpty(message = "Please provide your details")
  private String details;

  @Column(name = "requestRaisedBy")
  //@NotEmpty(message = "Please provide your requestRaisedBy")
  private String requestRaisedBy;

  @Column(name = "managerApproval")
  //@NotEmpty(message = "Please provide your managerApproval")
  private String managerApproval;

  @Column(name = "documentReceived ")
  //@NotEmpty(message = "Please provide your documentReceived ")
  private String documentReceived ;

  @Column(name = "wareConfirmation ")
  //@NotEmpty(message = "Please provide your wareConfirmation ")
  private String wareConfirmation ;

  @Column(name = "openingBalance")
  //@NotEmpty(message = "Please provide your openingBalance")
  private String openingBalance;

  @Column(name = "in")
  //@NotEmpty(message = "Please provide your in")
  private String in;

  @Column(name = "out")
  //@NotEmpty(message = "Please provide your out")
  private String out;

  @Column(name = "closingBalance")
  //@NotEmpty(message = "Please provide your closingBalance")
  private String closingBalance;

  @Column(name = "ratePerUnitPerDay")
  //@NotEmpty(message = "Please provide your ratePerUnitPerDay")
  private String ratePerUnitPerDay;

  @Column(name = "spaceCharge")
  //@NotEmpty(message = "Please provide your spaceCharge")
  private String spaceCharge;

  @Column(name = "loadingCharge")
  //@NotEmpty(message = "Please provide your loadingCharge")
  private String loadingCharge;

  @Column(name = "unloadingCharge")
  //@NotEmpty(message = "Please provide your unloadingCharge")
  private String unloadingCharge;

  @Column(name = "otherCharge")
  //@NotEmpty(message = "Please provide your otherCharge")
  private String otherCharge;

  @Column(name = "discount")
  //@NotEmpty(message = "Please provide your discount")
  private String discount;

  @Column(name = "tax")
  //@NotEmpty(message = "Please provide your tax")
  private String tax;

  @Column(name = "total")
  //@NotEmpty(message = "Please provide your total")
  private String total;

  @Column(name = "status")
  //@NotEmpty(message = "Please provide your status")
  private String status;

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
   * @return the orderDate
   */
  public String getOrderDate() {
    return orderDate;
  }

  /**
   * @author Anurag
   * @param orderDate the orderDate to set
   */
  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
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
   * @return the currentUnit
   */
  public String getCurrentUnit() {
    return currentUnit;
  }

  /**
   * @author Anurag
   * @param currentUnit the currentUnit to set
   */
  public void setCurrentUnit(String currentUnit) {
    this.currentUnit = currentUnit;
  }

  /**
   * @author Anurag
   * @return the currentStock
   */
  public String getCurrentStock() {
    return currentStock;
  }

  /**
   * @author Anurag
   * @param currentStock the currentStock to set
   */
  public void setCurrentStock(String currentStock) {
    this.currentStock = currentStock;
  }

  /**
   * @author Anurag
   * @return the details
   */
  public String getDetails() {
    return details;
  }

  /**
   * @author Anurag
   * @param details the details to set
   */
  public void setDetails(String details) {
    this.details = details;
  }

  /**
   * @author Anurag
   * @return the requestRaisedBy
   */
  public String getRequestRaisedBy() {
    return requestRaisedBy;
  }

  /**
   * @author Anurag
   * @param requestRaisedBy the requestRaisedBy to set
   */
  public void setRequestRaisedBy(String requestRaisedBy) {
    this.requestRaisedBy = requestRaisedBy;
  }

  /**
   * @author Anurag
   * @return the managerApproval
   */
  public String getManagerApproval() {
    return managerApproval;
  }

  /**
   * @author Anurag
   * @param managerApproval the managerApproval to set
   */
  public void setManagerApproval(String managerApproval) {
    this.managerApproval = managerApproval;
  }

  /**
   * @author Anurag
   * @return the documentReceived
   */
  public String getDocumentReceived() {
    return documentReceived;
  }

  /**
   * @author Anurag
   * @param documentReceived the documentReceived to set
   */
  public void setDocumentReceived(String documentReceived) {
    this.documentReceived = documentReceived;
  }

  /**
   * @author Anurag
   * @return the wareConfirmation
   */
  public String getWareConfirmation() {
    return wareConfirmation;
  }

  /**
   * @author Anurag
   * @param wareConfirmation the wareConfirmation to set
   */
  public void setWareConfirmation(String wareConfirmation) {
    this.wareConfirmation = wareConfirmation;
  }

  /**
   * @author Anurag
   * @return the openingBalance
   */
  public String getOpeningBalance() {
    return openingBalance;
  }

  /**
   * @author Anurag
   * @param openingBalance the openingBalance to set
   */
  public void setOpeningBalance(String openingBalance) {
    this.openingBalance = openingBalance;
  }

  /**
   * @author Anurag
   * @return the in
   */
  public String getIn() {
    return in;
  }

  /**
   * @author Anurag
   * @param in the in to set
   */
  public void setIn(String in) {
    this.in = in;
  }

  /**
   * @author Anurag
   * @return the out
   */
  public String getOut() {
    return out;
  }

  /**
   * @author Anurag
   * @param out the out to set
   */
  public void setOut(String out) {
    this.out = out;
  }

  /**
   * @author Anurag
   * @return the closingBalance
   */
  public String getClosingBalance() {
    return closingBalance;
  }

  /**
   * @author Anurag
   * @param closingBalance the closingBalance to set
   */
  public void setClosingBalance(String closingBalance) {
    this.closingBalance = closingBalance;
  }

  /**
   * @author Anurag
   * @return the ratePerUnitPerDay
   */
  public String getRatePerUnitPerDay() {
    return ratePerUnitPerDay;
  }

  /**
   * @author Anurag
   * @param ratePerUnitPerDay the ratePerUnitPerDay to set
   */
  public void setRatePerUnitPerDay(String ratePerUnitPerDay) {
    this.ratePerUnitPerDay = ratePerUnitPerDay;
  }

  /**
   * @author Anurag
   * @return the spaceCharge
   */
  public String getSpaceCharge() {
    return spaceCharge;
  }

  /**
   * @author Anurag
   * @param spaceCharge the spaceCharge to set
   */
  public void setSpaceCharge(String spaceCharge) {
    this.spaceCharge = spaceCharge;
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
   * @author Anurag
   * @return the discount
   */
  public String getDiscount() {
    return discount;
  }

  /**
   * @author Anurag
   * @param discount the discount to set
   */
  public void setDiscount(String discount) {
    this.discount = discount;
  }

  /**
   * @author Anurag
   * @return the tax
   */
  public String getTax() {
    return tax;
  }

  /**
   * @author Anurag
   * @param tax the tax to set
   */
  public void setTax(String tax) {
    this.tax = tax;
  }

  /**
   * @author Anurag
   * @return the total
   */
  public String getTotal() {
    return total;
  }

  /**
   * @author Anurag
   * @param total the total to set
   */
  public void setTotal(String total) {
    this.total = total;
  }

  /**
   * @author Anurag
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @author Anurag
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "OrderRequest [customerID=" + customerID + ", orderID=" + orderID + ", orderDate="
        + orderDate + ", warehouseID=" + warehouseID + ", currentUnit=" + currentUnit
        + ", currentStock=" + currentStock + ", details=" + details + ", requestRaisedBy="
        + requestRaisedBy + ", managerApproval=" + managerApproval + ", documentReceived="
        + documentReceived + ", wareConfirmation=" + wareConfirmation + ", openingBalance="
        + openingBalance + ", in=" + in + ", out=" + out + ", closingBalance=" + closingBalance
        + ", ratePerUnitPerDay=" + ratePerUnitPerDay + ", spaceCharge=" + spaceCharge
        + ", loadingCharge=" + loadingCharge + ", unloadingCharge=" + unloadingCharge
        + ", otherCharge=" + otherCharge + ", discount=" + discount + ", tax=" + tax + ", total="
        + total + ", status=" + status + "]";
  }

  
  
}
