/**
 * @author Anurag
 * @description 
 */
package com.example.bean;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Anurag
 * @description
 */
public class InputFormBean
{

	private String orderID;

	private String customerID;

	private String warehouseID;

	private String invoiceNo;

	private String invoiceDate;

	private String lCNo;

	private String dateOfIssue;

	private String customer;

	private String deliveryTerms;

	private String portOfImport;

	private String bLNo;

	private String bLDate;

	private String pONo;

	private String comments;

	/**
	 * @author Anurag
	 * @return the orderID
	 */
	public String getOrderID()
	{
		return orderID;
	}

	/**
	 * @author Anurag
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
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
	 * @return the invoiceNo
	 */
	public String getInvoiceNo()
	{
		return invoiceNo;
	}

	/**
	 * @author Anurag
	 * @param invoiceNo
	 *            the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo)
	{
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @author Anurag
	 * @return the invoiceDate
	 */
	public String getInvoiceDate()
	{
		return invoiceDate;
	}

	/**
	 * @author Anurag
	 * @param invoiceDate
	 *            the invoiceDate to set
	 */
	public void setInvoiceDate(String invoiceDate)
	{
		this.invoiceDate = invoiceDate;
	}

	/**
	 * @author Anurag
	 * @return the lCNo
	 */
	public String getlCNo()
	{
		return lCNo;
	}

	/**
	 * @author Anurag
	 * @param lCNo
	 *            the lCNo to set
	 */
	public void setlCNo(String lCNo)
	{
		this.lCNo = lCNo;
	}

	/**
	 * @author Anurag
	 * @return the dateOfIssue
	 */
	public String getDateOfIssue()
	{
		return dateOfIssue;
	}

	/**
	 * @author Anurag
	 * @param dateOfIssue
	 *            the dateOfIssue to set
	 */
	public void setDateOfIssue(String dateOfIssue)
	{
		this.dateOfIssue = dateOfIssue;
	}

	/**
	 * @author Anurag
	 * @return the customer
	 */
	public String getCustomer()
	{
		return customer;
	}

	/**
	 * @author Anurag
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer)
	{
		this.customer = customer;
	}

	/**
	 * @author Anurag
	 * @return the deliveryTerms
	 */
	public String getDeliveryTerms()
	{
		return deliveryTerms;
	}

	/**
	 * @author Anurag
	 * @param deliveryTerms
	 *            the deliveryTerms to set
	 */
	public void setDeliveryTerms(String deliveryTerms)
	{
		this.deliveryTerms = deliveryTerms;
	}

	/**
	 * @author Anurag
	 * @return the portOfImport
	 */
	public String getPortOfImport()
	{
		return portOfImport;
	}

	/**
	 * @author Anurag
	 * @param portOfImport
	 *            the portOfImport to set
	 */
	public void setPortOfImport(String portOfImport)
	{
		this.portOfImport = portOfImport;
	}

	/**
	 * @author Anurag
	 * @return the bLNo
	 */
	public String getbLNo()
	{
		return bLNo;
	}

	/**
	 * @author Anurag
	 * @param bLNo
	 *            the bLNo to set
	 */
	public void setbLNo(String bLNo)
	{
		this.bLNo = bLNo;
	}

	/**
	 * @author Anurag
	 * @return the bLDate
	 */
	public String getbLDate()
	{
		return bLDate;
	}

	/**
	 * @author Anurag
	 * @param bLDate
	 *            the bLDate to set
	 */
	public void setbLDate(String bLDate)
	{
		this.bLDate = bLDate;
	}

	/**
	 * @author Anurag
	 * @return the pONo
	 */
	public String getpONo()
	{
		return pONo;
	}

	/**
	 * @author Anurag
	 * @param pONo
	 *            the pONo to set
	 */
	public void setpONo(String pONo)
	{
		this.pONo = pONo;
	}

	/**
	 * @author Anurag
	 * @return the comments
	 */
	public String getComments()
	{
		return comments;
	}

	/**
	 * @author Anurag
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	@Override
	public String toString()
	{
		return "InputFormBean [orderID=" + orderID + ", customerID=" + customerID + ", warehouseID=" + warehouseID
				+ ", invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate + ", lCNo=" + lCNo + ", dateOfIssue="
				+ dateOfIssue + ", customer=" + customer + ", deliveryTerms=" + deliveryTerms + ", portOfImport="
				+ portOfImport + ", bLNo=" + bLNo + ", bLDate=" + bLDate + ", pONo=" + pONo + ", comments=" + comments
				+ "]";
	}

}
