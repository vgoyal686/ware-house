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
  public Boolean saveOrderRequest(OrderRequest orderRequest);
  public OrderRequest saveAndGetOrderRequest(OrderRequest orderRequest);
  public OrderRequest findByCustomerID(String customerID);
}
