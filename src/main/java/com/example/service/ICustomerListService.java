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
  CustomerList findByCustomerID(String customerID);
}
