/**
 * @author Anurag
 * @description 
 */
package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Anurag
 * @description
 */
@Entity
@Table(name = "OrderRequest")
public class OrderRequest
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderID") // @Column(name = "id")
	private int orderID;// private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@PrePersist
	protected void onCreate()
	{
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate()
	{
		updated = new Date();
	}

	// @Column(name = "orderID")
	// // @NotEmpty(message = "Please provide your orderID")
	// private String orderID;

	@Column(name = "orderDate")
	//@NotNull(message = "Please provide your orderDate")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "orderType")
	@NotEmpty(message = "Please provide your orderDate")
	private String orderType;

	@Column(name = "customerID")
	@NotEmpty(message = "Please provide your customerID")
	private String customerID;

	@Column(name = "warehouseID")
	@NotEmpty(message = "Please provide your warehouseID")
	private String warehouseID;

	@Column(name = "requestRaisedBy")
	@NotEmpty(message = "Please provide your requestRaisedBy")
	private String requestRaisedBy;

	@Column(name = "managerApproval")
	@NotNull(message = "Please provide your managerApproval")
	private int managerApproval = 0;

	@Column(name = "documentReceived")
	@NotNull(message = "Please provide your documentReceived ")
	private int documentReceived = 0;

	@Column(name = "wareConfirmation")
	@NotNull(message = "Please provide your wareConfirmation ")
	private int wareConfirmation = 0;

	@Column(name = "uom")
	@NotEmpty(message = "Please provide your in")
	private String uom;

	@Column(name = "ratePerUnitPerDay")
	@NotEmpty(message = "Please provide your ratePerUnitPerDay")
	private String ratePerUnitPerDay;

	@Column(name = "loadingCharge")
	// @NotEmpty(message = "Please provide your loadingCharge")
	private String loadingCharge;

	@Column(name = "unloadingCharge")
	// @NotEmpty(message = "Please provide your unloadingCharge")
	private String unloadingCharge;

	@Column(name = "otherCharge")
	// @NotEmpty(message = "Please provide your otherCharge")
	private String otherCharge;

	/******************************** OUT Form ***************************/

	@Column(name = "buyerName")
	// @NotEmpty(message = "Please provide your out")
	private String buyerName;

	@Column(name = "buyerPhoneNumber")
	// @NotEmpty(message = "Please provide your discount")
	private String buyerPhoneNumber;

	@Column(name = "buyerEmail")
	// @NotEmpty(message = "Please provide your tax")
	private String buyerEmail;

	@Column(name = "consigneeAddress")
	// @NotEmpty(message = "Please provide your total")
	private String consigneeAddress;

	@Column(name = "pinCode")
	// @NotEmpty(message = "Please provide your status")
	private String pinCode;

	@Column(name = "modeOfTransfer")
	// @NotEmpty(message = "Please provide your status")
	private String modeOfTransfer;

	@Column(name = "invoiceNumber")
	// @NotEmpty(message = "Please provide your status")
	private String invoiceNumber;

	@Column(name = "truckNumber")
	// @NotEmpty(message = "Please provide your status")
	private String truckNumber;

	@Column(name = "transportationCost")
	// @NotEmpty(message = "Please provide your status")
	private String transportationCost;

	@Column(name = "trackingID")
	// @NotEmpty(message = "Please provide your status")
	private String trackingID;

	@Column(name = "comment")
	// @NotEmpty(message = "Please provide your status")
	private String comment;

	/**
	 * @author Anurag
	 * @return the id
	 */
	public int getId()
	{
		return orderID;
	}

	/**
	 * @author Anurag
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.orderID = id;
	}

	/**
	 * @author Anurag
	 * @return the orderID
	 */
	public int getOrderID()
	{
		return orderID;
	}

	/**
	 * @author Anurag
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID(int orderID)
	{
		this.orderID = orderID;
	}

	/**
	 * @author Anurag
	 * @return the created
	 */
	public Date getCreated()
	{
		return created;
	}

	/**
	 * @author Anurag
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created)
	{
		this.created = created;
	}

	/**
	 * @author Anurag
	 * @return the updated
	 */
	public Date getUpdated()
	{
		return updated;
	}

	/**
	 * @author Anurag
	 * @param updated
	 *            the updated to set
	 */
	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}

	/**
	 * @author Anurag
	 * @return the orderDate
	 */
	public Date getOrderDate()
	{
		return orderDate;
	}

	/**
	 * @author Anurag
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	/**
	 * @author Anurag
	 * @return the orderType
	 */
	public String getOrderType()
	{
		return orderType;
	}

	/**
	 * @author Anurag
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}

	/**
	 * @author Anurag
	 * @return the customerID
	 */
	public String getCustomerID()
	{
		return customerID;
	}

	/**
	 * @author Anurag
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(String customerID)
	{
		this.customerID = customerID;
	}

	/**
	 * @author Anurag
	 * @return the warehouseID
	 */
	public String getWarehouseID()
	{
		return warehouseID;
	}

	/**
	 * @author Anurag
	 * @param warehouseID
	 *            the warehouseID to set
	 */
	public void setWarehouseID(String warehouseID)
	{
		this.warehouseID = warehouseID;
	}

	/**
	 * @author Anurag
	 * @return the requestRaisedBy
	 */
	public String getRequestRaisedBy()
	{
		return requestRaisedBy;
	}

	/**
	 * @author Anurag
	 * @param requestRaisedBy
	 *            the requestRaisedBy to set
	 */
	public void setRequestRaisedBy(String requestRaisedBy)
	{
		this.requestRaisedBy = requestRaisedBy;
	}
	
	
	/**
   * @author Anurag
   * @return the managerApproval
   */
  public int getManagerApproval() {
    return managerApproval;
  }

  /**
   * @author Anurag
   * @param managerApproval the managerApproval to set
   */
  public void setManagerApproval(int managerApproval) {
    this.managerApproval = managerApproval;
  }

  /**
   * @author Anurag
   * @return the documentReceived
   */
  public int getDocumentReceived() {
    return documentReceived;
  }

  /**
   * @author Anurag
   * @param documentReceived the documentReceived to set
   */
  public void setDocumentReceived(int documentReceived) {
    this.documentReceived = documentReceived;
  }

  /**
   * @author Anurag
   * @return the wareConfirmation
   */
  public int getWareConfirmation() {
    return wareConfirmation;
  }

  /**
   * @author Anurag
   * @param wareConfirmation the wareConfirmation to set
   */
  public void setWareConfirmation(int wareConfirmation) {
    this.wareConfirmation = wareConfirmation;
  }

  /**
	 * @author Anurag
	 * @return the uom
	 */
	public String getUom()
	{
		return uom;
	}

	/**
	 * @author Anurag
	 * @param uom
	 *            the uom to set
	 */
	public void setUom(String uom)
	{
		this.uom = uom;
	}

	/**
	 * @author Anurag
	 * @return the ratePerUnitPerDay
	 */
	public String getRatePerUnitPerDay()
	{
		return ratePerUnitPerDay;
	}

	/**
	 * @author Anurag
	 * @param ratePerUnitPerDay
	 *            the ratePerUnitPerDay to set
	 */
	public void setRatePerUnitPerDay(String ratePerUnitPerDay)
	{
		this.ratePerUnitPerDay = ratePerUnitPerDay;
	}

	/**
	 * @author Anurag
	 * @return the loadingCharge
	 */
	public String getLoadingCharge()
	{
		return loadingCharge;
	}

	/**
	 * @author Anurag
	 * @param loadingCharge
	 *            the loadingCharge to set
	 */
	public void setLoadingCharge(String loadingCharge)
	{
		this.loadingCharge = loadingCharge;
	}

	/**
	 * @author Anurag
	 * @return the unloadingCharge
	 */
	public String getUnloadingCharge()
	{
		return unloadingCharge;
	}

	/**
	 * @author Anurag
	 * @param unloadingCharge
	 *            the unloadingCharge to set
	 */
	public void setUnloadingCharge(String unloadingCharge)
	{
		this.unloadingCharge = unloadingCharge;
	}

	/**
	 * @author Anurag
	 * @return the otherCharge
	 */
	public String getOtherCharge()
	{
		return otherCharge;
	}

	/**
	 * @author Anurag
	 * @param otherCharge
	 *            the otherCharge to set
	 */
	public void setOtherCharge(String otherCharge)
	{
		this.otherCharge = otherCharge;
	}

	/**
	 * @author Anurag
	 * @return the buyerName
	 */
	public String getBuyerName()
	{
		return buyerName;
	}

	/**
	 * @author Anurag
	 * @param buyerName
	 *            the buyerName to set
	 */
	public void setBuyerName(String buyerName)
	{
		this.buyerName = buyerName;
	}

	/**
	 * @author Anurag
	 * @return the buyerPhoneNumber
	 */
	public String getBuyerPhoneNumber()
	{
		return buyerPhoneNumber;
	}

	/**
	 * @author Anurag
	 * @param buyerPhoneNumber
	 *            the buyerPhoneNumber to set
	 */
	public void setBuyerPhoneNumber(String buyerPhoneNumber)
	{
		this.buyerPhoneNumber = buyerPhoneNumber;
	}

	/**
	 * @author Anurag
	 * @return the buyerEmail
	 */
	public String getBuyerEmail()
	{
		return buyerEmail;
	}

	/**
	 * @author Anurag
	 * @param buyerEmail
	 *            the buyerEmail to set
	 */
	public void setBuyerEmail(String buyerEmail)
	{
		this.buyerEmail = buyerEmail;
	}

	/**
	 * @author Anurag
	 * @return the consigneeAddress
	 */
	public String getConsigneeAddress()
	{
		return consigneeAddress;
	}

	/**
	 * @author Anurag
	 * @param consigneeAddress
	 *            the consigneeAddress to set
	 */
	public void setConsigneeAddress(String consigneeAddress)
	{
		this.consigneeAddress = consigneeAddress;
	}

	/**
	 * @author Anurag
	 * @return the pinCode
	 */
	public String getPinCode()
	{
		return pinCode;
	}

	/**
	 * @author Anurag
	 * @param pinCode
	 *            the pinCode to set
	 */
	public void setPinCode(String pinCode)
	{
		this.pinCode = pinCode;
	}

	/**
	 * @author Anurag
	 * @return the modeOfTransfer
	 */
	public String getModeOfTransfer()
	{
		return modeOfTransfer;
	}

	/**
	 * @author Anurag
	 * @param modeOfTransfer
	 *            the modeOfTransfer to set
	 */
	public void setModeOfTransfer(String modeOfTransfer)
	{
		this.modeOfTransfer = modeOfTransfer;
	}

	/**
	 * @author Anurag
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber()
	{
		return invoiceNumber;
	}

	/**
	 * @author Anurag
	 * @param invoiceNumber
	 *            the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber)
	{
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @author Anurag
	 * @return the truckNumber
	 */
	public String getTruckNumber()
	{
		return truckNumber;
	}

	/**
	 * @author Anurag
	 * @param truckNumber
	 *            the truckNumber to set
	 */
	public void setTruckNumber(String truckNumber)
	{
		this.truckNumber = truckNumber;
	}

	/**
	 * @author Anurag
	 * @return the transportationCost
	 */
	public String getTransportationCost()
	{
		return transportationCost;
	}

	/**
	 * @author Anurag
	 * @param transportationCost
	 *            the transportationCost to set
	 */
	public void setTransportationCost(String transportationCost)
	{
		this.transportationCost = transportationCost;
	}

	/**
	 * @author Anurag
	 * @return the trackingID
	 */
	public String getTrackingID()
	{
		return trackingID;
	}

	/**
	 * @author Anurag
	 * @param trackingID
	 *            the trackingID to set
	 */
	public void setTrackingID(String trackingID)
	{
		this.trackingID = trackingID;
	}

	/**
	 * @author Anurag
	 * @return the comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * @author Anurag
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}


	/**
   * @param orderID
   * @param created
   * @param updated
   * @param orderDate
   * @param orderType
   * @param customerID
   * @param warehouseID
   * @param requestRaisedBy
   * @param managerApproval
   * @param documentReceived
   * @param wareConfirmation
   * @param uom
   * @param ratePerUnitPerDay
   * @param loadingCharge
   * @param unloadingCharge
   * @param otherCharge
   * @param buyerName
   * @param buyerPhoneNumber
   * @param buyerEmail
   * @param consigneeAddress
   * @param pinCode
   * @param modeOfTransfer
   * @param invoiceNumber
   * @param truckNumber
   * @param transportationCost
   * @param trackingID
   * @param comment
   */
  public OrderRequest(int orderID, Date created, Date updated, Date orderDate, String orderType,
      String customerID, String warehouseID, String requestRaisedBy, int managerApproval,
      int documentReceived, int wareConfirmation, String uom, String ratePerUnitPerDay,
      String loadingCharge, String unloadingCharge, String otherCharge, String buyerName,
      String buyerPhoneNumber, String buyerEmail, String consigneeAddress, String pinCode,
      String modeOfTransfer, String invoiceNumber, String truckNumber, String transportationCost,
      String trackingID, String comment) {
    super();
    this.orderID = orderID;
    this.created = created;
    this.updated = updated;
    this.orderDate = orderDate;
    this.orderType = orderType;
    this.customerID = customerID;
    this.warehouseID = warehouseID;
    this.requestRaisedBy = requestRaisedBy;
    this.managerApproval = managerApproval;
    this.documentReceived = documentReceived;
    this.wareConfirmation = wareConfirmation;
    this.uom = uom;
    this.ratePerUnitPerDay = ratePerUnitPerDay;
    this.loadingCharge = loadingCharge;
    this.unloadingCharge = unloadingCharge;
    this.otherCharge = otherCharge;
    this.buyerName = buyerName;
    this.buyerPhoneNumber = buyerPhoneNumber;
    this.buyerEmail = buyerEmail;
    this.consigneeAddress = consigneeAddress;
    this.pinCode = pinCode;
    this.modeOfTransfer = modeOfTransfer;
    this.invoiceNumber = invoiceNumber;
    this.truckNumber = truckNumber;
    this.transportationCost = transportationCost;
    this.trackingID = trackingID;
    this.comment = comment;
  }

  /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "OrderRequest [orderID=" + orderID + ", created=" + created + ", updated=" + updated + ", orderDate="
				+ orderDate + ", orderType=" + orderType + ", customerID=" + customerID + ", warehouseID=" + warehouseID
				+ ", requestRaisedBy=" + requestRaisedBy + ", managerApproval=" + managerApproval
				+ ", documentReceived=" + documentReceived + ", wareConfirmation=" + wareConfirmation + ", uom=" + uom
				+ ", ratePerUnitPerDay=" + ratePerUnitPerDay + ", loadingCharge=" + loadingCharge + ", unloadingCharge="
				+ unloadingCharge + ", otherCharge=" + otherCharge + ", buyerName=" + buyerName + ", buyerPhoneNumber="
				+ buyerPhoneNumber + ", buyerEmail=" + buyerEmail + ", consigneeAddress=" + consigneeAddress
				+ ", pinCode=" + pinCode + ", modeOfTransfer=" + modeOfTransfer + ", invoiceNumber=" + invoiceNumber
				+ ", truckNumber=" + truckNumber + ", transportationCost=" + transportationCost + ", trackingID="
				+ trackingID + ", comment=" + comment + "]";
	}

	/**
	 * 
	 */
	public OrderRequest()
	{
		super();
	}

}
