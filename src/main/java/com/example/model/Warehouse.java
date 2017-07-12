package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "warehouse")
public class Warehouse
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@NotEmpty(message = "*Please provide your name")
	private String name;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "phone1")
	@NotEmpty(message = "*Please provide an phone number 1")
	private String phone1;

	@Column(name = "phone2")
	@NotEmpty(message = "*Please provide an phone number 2")
	private String phone2;

	@Column(name = "totalspace")
	@NotEmpty(message = "*Please provide your area")
	private String totalspace;

	@Column(name = "availablespace")
	@NotEmpty(message = "*Please provide your remarea")
	private String availablespace;

	@Column(name = "state")
	@NotEmpty(message = "*Please provide your state")
	private String state;

	@Column(name = "city")
	@NotEmpty(message = "*Please provide your city")
	private String city;

	@Column(name = "pincode")
	@NotEmpty(message = "*Please provide your pincode")
	private String pincode;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone1()
	{
		return phone1;
	}

	public void setPhone1(String phone1)
	{
		this.phone1 = phone1;
	}

	public String getPhone2()
	{
		return phone2;
	}

	public void setPhone2(String phone2)
	{
		this.phone2 = phone2;
	}

	public String getTotalspace()
	{
		return totalspace;
	}

	public void setTotalspace(String totalspace)
	{
		this.totalspace = totalspace;
	}

	public String getAvailablespace()
	{
		return availablespace;
	}

	public void setAvailablespace(String availablespace)
	{
		this.availablespace = availablespace;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}

	@Override
	public String toString()
	{
		return "warehouse [id=" + id + ", name=" + name + ", email=" + email + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", totalspace=" + totalspace + ", availablespace=" + availablespace + ", state=" + state
				+ ", city=" + city + ", pincode=" + pincode + "]";
	}

}
