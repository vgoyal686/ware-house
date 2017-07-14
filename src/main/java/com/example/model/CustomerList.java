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
@Table(name = "CustomerList")
public class CustomerList {
  
  @Column(name = "customerID")
  @NotEmpty(message = "*Please provide your customerID")
  private String customerID;

  @Column(name = "firstName")
  @NotEmpty(message = "*Please provide your firstName")
  private String firstName;

  @Column(name = "middleName")
  //@NotEmpty(message = "*Please provide your middleName")
  private String middleName;

  @Column(name = "lastName")
  //@NotEmpty(message = "*Please provide your lastName")
  private String lastName;

  @Column(name = "addressLine1")
  @NotEmpty(message = "*Please provide your addressLine1")
  private String addressLine1;

  @Column(name = "addressLine2")
  @NotEmpty(message = "*Please provide your addressLine2")
  private String addressLine2;

  @Column(name = "city")
  @NotEmpty(message = "*Please provide your city")
  private String city;

  @Column(name = "state")
  @NotEmpty(message = "*Please provide your state")
  private String state;

  @Column(name = "zip")
  //@NotEmpty(message = "*Please provide your zip")
  private String zip;

  @Column(name = "billingAddressLine1")
  @NotEmpty(message = "*Please provide your billingAddressLine1")
  private String billingAddressLine1;

  @Column(name = "billingAddress")
  @NotEmpty(message = "*Please provide your billingAddress")
  private String billingAddress;

  @Column(name = "billingState")
  @NotEmpty(message = "*Please provide your billingState")
  private String billingState;

  @Column(name = "billingCity")
  @NotEmpty(message = "*Please provide your billingCity")
  private String billingCity;

  @Column(name = "priorityCity1")
  //@NotEmpty(message = "*Please provide your priorityCity1")
  private String priorityCity1;

  @Column(name = "priorityCity2")
  //@NotEmpty(message = "*Please provide your priorityCity2")
  private String priorityCity2;

  @Column(name = "contactNumber")
  @NotEmpty(message = "*Please provide your contactNumber")
  private String contactNumber;

  @Column(name = "emailID")
  @NotEmpty(message = "*Please provide your emailID")
  private String emailID;

  @Column(name = "url")
  //@NotEmpty(message = "*Please provide your url")
  private String url;

  @Column(name = "addressProof1")
  @NotEmpty(message = "*Please provide your addressProof1")
  private String addressProof1;

  @Column(name = "addressProof2")
  @NotEmpty(message = "*Please provide your addressProof2")
  private String addressProof2;

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
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @author Anurag
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @author Anurag
   * @return the middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * @author Anurag
   * @param middleName the middleName to set
   */
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  /**
   * @author Anurag
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @author Anurag
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @author Anurag
   * @return the addressLine1
   */
  public String getAddressLine1() {
    return addressLine1;
  }

  /**
   * @author Anurag
   * @param addressLine1 the addressLine1 to set
   */
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  /**
   * @author Anurag
   * @return the addressLine2
   */
  public String getAddressLine2() {
    return addressLine2;
  }

  /**
   * @author Anurag
   * @param addressLine2 the addressLine2 to set
   */
  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  /**
   * @author Anurag
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @author Anurag
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @author Anurag
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @author Anurag
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @author Anurag
   * @return the zip
   */
  public String getZip() {
    return zip;
  }

  /**
   * @author Anurag
   * @param zip the zip to set
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * @author Anurag
   * @return the billingAddressLine1
   */
  public String getBillingAddressLine1() {
    return billingAddressLine1;
  }

  /**
   * @author Anurag
   * @param billingAddressLine1 the billingAddressLine1 to set
   */
  public void setBillingAddressLine1(String billingAddressLine1) {
    this.billingAddressLine1 = billingAddressLine1;
  }

  /**
   * @author Anurag
   * @return the billingAddress
   */
  public String getBillingAddress() {
    return billingAddress;
  }

  /**
   * @author Anurag
   * @param billingAddress the billingAddress to set
   */
  public void setBillingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
  }

  /**
   * @author Anurag
   * @return the billingState
   */
  public String getBillingState() {
    return billingState;
  }

  /**
   * @author Anurag
   * @param billingState the billingState to set
   */
  public void setBillingState(String billingState) {
    this.billingState = billingState;
  }

  /**
   * @author Anurag
   * @return the billingCity
   */
  public String getBillingCity() {
    return billingCity;
  }

  /**
   * @author Anurag
   * @param billingCity the billingCity to set
   */
  public void setBillingCity(String billingCity) {
    this.billingCity = billingCity;
  }

  /**
   * @author Anurag
   * @return the priorityCity1
   */
  public String getPriorityCity1() {
    return priorityCity1;
  }

  /**
   * @author Anurag
   * @param priorityCity1 the priorityCity1 to set
   */
  public void setPriorityCity1(String priorityCity1) {
    this.priorityCity1 = priorityCity1;
  }

  /**
   * @author Anurag
   * @return the priorityCity2
   */
  public String getPriorityCity2() {
    return priorityCity2;
  }

  /**
   * @author Anurag
   * @param priorityCity2 the priorityCity2 to set
   */
  public void setPriorityCity2(String priorityCity2) {
    this.priorityCity2 = priorityCity2;
  }

  /**
   * @author Anurag
   * @return the contactNumber
   */
  public String getContactNumber() {
    return contactNumber;
  }

  /**
   * @author Anurag
   * @param contactNumber the contactNumber to set
   */
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  /**
   * @author Anurag
   * @return the emailID
   */
  public String getEmailID() {
    return emailID;
  }

  /**
   * @author Anurag
   * @param emailID the emailID to set
   */
  public void setEmailID(String emailID) {
    this.emailID = emailID;
  }

  /**
   * @author Anurag
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @author Anurag
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @author Anurag
   * @return the addressProof1
   */
  public String getAddressProof1() {
    return addressProof1;
  }

  /**
   * @author Anurag
   * @param addressProof1 the addressProof1 to set
   */
  public void setAddressProof1(String addressProof1) {
    this.addressProof1 = addressProof1;
  }

  /**
   * @author Anurag
   * @return the addressProof2
   */
  public String getAddressProof2() {
    return addressProof2;
  }

  /**
   * @author Anurag
   * @param addressProof2 the addressProof2 to set
   */
  public void setAddressProof2(String addressProof2) {
    this.addressProof2 = addressProof2;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CustomerList [customerID=" + customerID + ", firstName=" + firstName + ", middleName="
        + middleName + ", lastName=" + lastName + ", addressLine1=" + addressLine1
        + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", zip=" + zip
        + ", billingAddressLine1=" + billingAddressLine1 + ", billingAddress=" + billingAddress
        + ", billingState=" + billingState + ", billingCity=" + billingCity + ", priorityCity1="
        + priorityCity1 + ", priorityCity2=" + priorityCity2 + ", contactNumber=" + contactNumber
        + ", emailID=" + emailID + ", url=" + url + ", addressProof1=" + addressProof1
        + ", addressProof2=" + addressProof2 + "]";
  }

  
  
}
