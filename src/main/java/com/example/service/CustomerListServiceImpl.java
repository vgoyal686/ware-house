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
  public Boolean saveCustomerList(CustomerList customerList) {
    
    try{
      customerListRepository.save(customerList);
    } catch(Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public CustomerList saveAndGetCustomerList(CustomerList customerList) {
    
    return customerListRepository.save(customerList);
  }

  @Override
  public CustomerList findByCustomerID(String customerID) {

    return customerListRepository.findByCustomerID(customerID);
  }


}
