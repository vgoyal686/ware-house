/**
 * @author Anurag
 * @description 
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CustomerList;
import com.example.repository.ICustomerListRepository;

/**
 * @author Anurag
 * @description 
 */
@Service("customerListService")
public class CustomerListServiceImpl implements ICustomerListService{

  @Autowired
  private ICustomerListRepository customerListRepository;

  @Override
  public CustomerList findByCustomerID(String customerID) {
    // TODO Auto-generated method stub
    return null;
  }
}
