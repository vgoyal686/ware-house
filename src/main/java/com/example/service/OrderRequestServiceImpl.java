/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
      e.printStackTrace();
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
    
  //  return orderRequestRepository.findByCustomerID(customerID);
	  
	  return new OrderRequest();
  }


  
  @Override
  public  Iterable<OrderRequest> listByCustomerID(String customerID) {
    
    return orderRequestRepository.findByCustomerID(customerID);
  }
  
 
  @Override
  public  List<OrderRequest> findAllOrderRequest() {
    
    return orderRequestRepository.findAll();
  }
  
  
  
  @Override
  public Page<OrderRequest> getAllOrderRequestWithPagination(Pageable pageable) {
      Page<OrderRequest> blogList = orderRequestRepository.findAll(pageable);
      return blogList;
  }

}
