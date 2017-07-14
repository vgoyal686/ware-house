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

  private IOrderRequestRepository orderRequestRepository;
  
  @Override
  public OrderRequest findByCustomerID(String customerID) {
    // TODO Auto-generated method stub
    return null;
  }

}
