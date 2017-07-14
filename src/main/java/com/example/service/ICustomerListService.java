/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import com.example.model.CustomerList;

/**
 * @author Anurag
 * @description 
 */
public interface ICustomerListService {
  public Boolean saveCustomerList(CustomerList customerList);
  public CustomerList saveAndGetCustomerList(CustomerList customerList);
  public CustomerList findByCustomerID(String customerID);
}
