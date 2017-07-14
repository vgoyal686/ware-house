/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import com.example.model.OrderRequest;

/**
 * @author Anurag
 * @description 
 */
public interface IOrderRequestService {
  OrderRequest findByCustomerID(String customerID);
}
