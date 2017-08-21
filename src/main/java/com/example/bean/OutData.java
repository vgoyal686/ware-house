package com.example.bean;

import org.springframework.web.bind.annotation.RequestParam;

public class OutData
{
	private String level;
	private String levelName;
	private String levelValue;
	private String levelCat;

	private String id;
	private String customerId;
	private String warehouseID;
	private String orderID;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getWarehouseID()
	{
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID)
	{
		this.warehouseID = warehouseID;
	}

	public String getOrderID()
	{
		return orderID;
	}

	public void setOrderID(String orderID)
	{
		this.orderID = orderID;
	}

	public String getLevelCat()
	{
		return levelCat;
	}

	public void setLevelCat(String levelCat)
	{
		this.levelCat = levelCat;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public String getLevelName()
	{
		return levelName;
	}

	public void setLevelName(String levelName)
	{
		this.levelName = levelName;
	}

	public String getLevelValue()
	{
		return levelValue;
	}

	public void setLevelValue(String levelValue)
	{
		this.levelValue = levelValue;
	}

	

}
