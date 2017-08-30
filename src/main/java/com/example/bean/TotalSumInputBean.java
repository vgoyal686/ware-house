package com.example.bean;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class TotalSumInputBean
{
	private String customerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide your orderDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	@Override
	public String toString()
	{
		return "TotalSumInputBean [customerId=" + customerId + ", orderDate=" + orderDate + "]";
	}

}
