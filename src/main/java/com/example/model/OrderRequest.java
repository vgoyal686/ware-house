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
	@Column(name = "id")
	private int id;

	@Column(name = "customerID")
	// @NotEmpty(message = "Please provide your customerID")
	private String customerID;

	@Column(name = "orderID")
	// @NotEmpty(message = "Please provide your orderID")
	private String orderID;

	@Column(name = "orderDate")
	// @NotEmpty(message = "Please provide your orderDate")
	private String orderDate;

	@Column(name = "warehouseID")
	// @NotEmpty(message = "Please provide your warehouseID")
	private String warehouseID;

	@Column(name = "currentUnit")
	// @NotEmpty(message = "Please provide your currentUnit")
	private String currentUnit;

	@Column(name = "currentStock")
	// @NotEmpty(message = "Please provide your currentStock")
	private String currentStock;

	@Column(name = "details")
	// @NotEmpty(message = "Please provide your details")
	private String details;

	@Column(name = "requestRaisedBy")
	// @NotEmpty(message = "Please provide your requestRaisedBy")
	private String requestRaisedBy;

	@Column(name = "managerApproval")
	// @NotEmpty(message = "Please provide your managerApproval")
	private String managerApproval;

	@Column(name = "documentReceived ")
	// @NotEmpty(message = "Please provide your documentReceived ")
	private String documentReceived;

	@Column(name = "wareConfirmation ")
	// @NotEmpty(message = "Please provide your wareConfirmation ")
	private String wareConfirmation;

	@Column(name = "openingBalance")
	// @NotEmpty(message = "Please provide your openingBalance")
	private String openingBalance;

	@Column(name = "input")
	// @NotEmpty(message = "Please provide your in")
	private String input;

	@Column(name = "output")
	// @NotEmpty(message = "Please provide your out")
	private String output;

	@Column(name = "closingBalance")
	// @NotEmpty(message = "Please provide your closingBalance")
	private String closingBalance;

	@Column(name = "ratePerUnitPerDay")
	// @NotEmpty(message = "Please provide your ratePerUnitPerDay")
	private String ratePerUnitPerDay;

	@Column(name = "spaceCharge")
	// @NotEmpty(message = "Please provide your spaceCharge")
	private String spaceCharge;

	@Column(name = "loadingCharge")
	// @NotEmpty(message = "Please provide your loadingCharge")
	private String loadingCharge;

	@Column(name = "unloadingCharge")
	// @NotEmpty(message = "Please provide your unloadingCharge")
	private String unloadingCharge;

	@Column(name = "otherCharge")
	// @NotEmpty(message = "Please provide your otherCharge")
	private String otherCharge;

	@Column(name = "discount")
	// @NotEmpty(message = "Please provide your discount")
	private String discount;

	@Column(name = "tax")
	// @NotEmpty(message = "Please provide your tax")
	private String tax;

	@Column(name = "total")
	// @NotEmpty(message = "Please provide your total")
	private String total;

	@Column(name = "status")
	// @NotEmpty(message = "Please provide your status")
	private String status;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(String customerID)
	{
		this.customerID = customerID;
	}

	public String getOrderID()
	{
		return orderID;
	}

	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
	}

	public String getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(String orderDate)
	{
		this.orderDate = orderDate;
	}

	public String getWarehouseID()
	{
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID)
	{
		this.warehouseID = warehouseID;
	}

	public String getCurrentUnit()
	{
		return currentUnit;
	}

	public void setCurrentUnit(String currentUnit)
	{
		this.currentUnit = currentUnit;
	}

	public String getCurrentStock()
	{
		return currentStock;
	}

	public void setCurrentStock(String currentStock)
	{
		this.currentStock = currentStock;
	}

	public String getDetails()
	{
		return details;
	}

	public void setDetails(String details)
	{
		this.details = details;
	}

	public String getRequestRaisedBy()
	{
		return requestRaisedBy;
	}

	public void setRequestRaisedBy(String requestRaisedBy)
	{
		this.requestRaisedBy = requestRaisedBy;
	}

	public String getManagerApproval()
	{
		return managerApproval;
	}

	public void setManagerApproval(String managerApproval)
	{
		this.managerApproval = managerApproval;
	}

	public String getDocumentReceived()
	{
		return documentReceived;
	}

	public void setDocumentReceived(String documentReceived)
	{
		this.documentReceived = documentReceived;
	}

	public String getWareConfirmation()
	{
		return wareConfirmation;
	}

	public void setWareConfirmation(String wareConfirmation)
	{
		this.wareConfirmation = wareConfirmation;
	}

	public String getOpeningBalance()
	{
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance)
	{
		this.openingBalance = openingBalance;
	}

	public String getInput()
	{
		return input;
	}

	public void setInput(String input)
	{
		this.input = input;
	}

	public String getOutput()
	{
		return output;
	}

	public void setOutput(String output)
	{
		this.output = output;
	}

	public String getClosingBalance()
	{
		return closingBalance;
	}

	public void setClosingBalance(String closingBalance)
	{
		this.closingBalance = closingBalance;
	}

	public String getRatePerUnitPerDay()
	{
		return ratePerUnitPerDay;
	}

	public void setRatePerUnitPerDay(String ratePerUnitPerDay)
	{
		this.ratePerUnitPerDay = ratePerUnitPerDay;
	}

	public String getSpaceCharge()
	{
		return spaceCharge;
	}

	public void setSpaceCharge(String spaceCharge)
	{
		this.spaceCharge = spaceCharge;
	}

	public String getLoadingCharge()
	{
		return loadingCharge;
	}

	public void setLoadingCharge(String loadingCharge)
	{
		this.loadingCharge = loadingCharge;
	}

	public String getUnloadingCharge()
	{
		return unloadingCharge;
	}

	public void setUnloadingCharge(String unloadingCharge)
	{
		this.unloadingCharge = unloadingCharge;
	}

	public String getOtherCharge()
	{
		return otherCharge;
	}

	public void setOtherCharge(String otherCharge)
	{
		this.otherCharge = otherCharge;
	}

	public String getDiscount()
	{
		return discount;
	}

	public void setDiscount(String discount)
	{
		this.discount = discount;
	}

	public String getTax()
	{
		return tax;
	}

	public void setTax(String tax)
	{
		this.tax = tax;
	}

	public String getTotal()
	{
		return total;
	}

	public void setTotal(String total)
	{
		this.total = total;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "OrderRequest [id=" + id + ", customerID=" + customerID + ", orderID=" + orderID + ", orderDate="
				+ orderDate + ", warehouseID=" + warehouseID + ", currentUnit=" + currentUnit + ", currentStock="
				+ currentStock + ", details=" + details + ", requestRaisedBy=" + requestRaisedBy + ", managerApproval="
				+ managerApproval + ", documentReceived=" + documentReceived + ", wareConfirmation=" + wareConfirmation
				+ ", openingBalance=" + openingBalance + ", input=" + input + ", output=" + output + ", closingBalance="
				+ closingBalance + ", ratePerUnitPerDay=" + ratePerUnitPerDay + ", spaceCharge=" + spaceCharge
				+ ", loadingCharge=" + loadingCharge + ", unloadingCharge=" + unloadingCharge + ", otherCharge="
				+ otherCharge + ", discount=" + discount + ", tax=" + tax + ", total=" + total + ", status=" + status
				+ "]";
	}

}
