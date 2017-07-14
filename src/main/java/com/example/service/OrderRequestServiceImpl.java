/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.OrderRequest;
import com.example.repository.IOrderRequestRepository;

/**
 * @author Anurag
 * @description 
 */
@Service("orderRequestService")
public class OrderRequestServiceImpl implements IOrderRequestService {

  @Autowired
  private IOrderRequestRepository orderRequestRepository;
  
  @Override
  public Boolean saveOrderRequest(OrderRequest orderRequest) {
    
    try{ 
      orderRequestRepository.save(orderRequest);
    } catch(Exception e){
      return false;
    }
    return true;
  }
  
  @Override
  public OrderRequest saveAndGetOrderRequest(OrderRequest orderRequest) {
    
    return orderRequestRepository.save(orderRequest);
  }

  @Override
  public OrderRequest findByCustomerID(String customerID) {
    
    return orderRequestRepository.findByCustomerID(customerID);
  }



}
