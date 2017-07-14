/**
 * @author Anurag
 * @description 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CustomerList;

/**
 * @author Anurag
 * @description 
 */
@Repository("customerListRepository")
public interface ICustomerListRepository extends JpaRepository<CustomerList, Long> {

  CustomerList findByCustomerID(String customerID);  

}
