package com.example.bean;

public class OutData
{
	private String level;
	private String levelName;
	private String levelValue;
	private String levelCat; 
	
	
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
	@Override
	public String toString()
	{
		return "OutData [level=" + level + ", levelName=" + levelName + ", levelValue=" + levelValue + ", levelCat="
				+ levelCat + "]";
	}
	
}
